package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.access.AccessLimit;
import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.common.Result;
import com.zhonghuasheng.seckill.domain.OrderInfo;
import com.zhonghuasheng.seckill.domain.SecKillUser;
import com.zhonghuasheng.seckill.domain.SeckillOrder;
import com.zhonghuasheng.seckill.rabbitmq.MQSender;
import com.zhonghuasheng.seckill.rabbitmq.SeckillMessage;
import com.zhonghuasheng.seckill.redis.GoodsKey;
import com.zhonghuasheng.seckill.redis.RedisService;
import com.zhonghuasheng.seckill.service.GoodsService;
import com.zhonghuasheng.seckill.service.OrderService;
import com.zhonghuasheng.seckill.service.SeckillService;
import com.zhonghuasheng.seckill.vo.GoodsVo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/seckill")
public class SeckillController implements InitializingBean {

    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderService orderService;
    @Autowired
    SeckillService seckillService;
    @Autowired
    RedisService redisService;
    @Autowired
    MQSender sender;

    private HashMap<Long, Boolean> localOverMap = new HashMap<>();

    // 这个版本是直接在数据库减库存，QPS不高，只有1200左右（10秒内50000个请求）
    @RequestMapping()
    public String seckill(Model model, SecKillUser user, @RequestParam("goodsId") long goodsId) {
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        // 判断库存
        GoodsVo goods = goodsService.getById(goodsId);
        if (goods.getStockCount() <= 0) {
            model.addAttribute("errmsg", CodeMsg.SECKILL_OVER.getMsg());
            return "seckill_fail";
        }
        // 判断是否已经秒杀到了
        SeckillOrder seckillOrder = orderService.getSeckillOrderByUserIdAndGoodsId(user.getId(), goodsId);
        if (seckillOrder != null) {
            model.addAttribute("errmsg", CodeMsg.REPEATE_SECKILL.getMsg());
            return "seckill_fail";
        }
        // 减库存 下订单 写入秒杀订单
        OrderInfo orderInfo = seckillService.seckill(user, goods);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goods);
        System.out.println(orderInfo.toString());
        return "order_detail";
    }

    // 这个版本是借助Redis缓存，将秒杀结果写入缓存，依旧是数据库中直接操作库存，QPS 2100
    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ResponseBody
    public Result<OrderInfo> doSeckill(SecKillUser user, @RequestParam("goodsId") long goodsId) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        // 判断库存
        GoodsVo goods = goodsService.getById(goodsId);
        if (goods.getStockCount() <= 0) {
            return Result.error(CodeMsg.SECKILL_OVER);
        }
        // 判断是否已经秒杀到了
        SeckillOrder order = orderService.getSeckillOrderByUserIdAndGoodsId(user.getId(), goodsId);
        if (order != null) {
            return Result.error(CodeMsg.REPEATE_SECKILL);
        }
        // 减库存 下订单 写入秒杀订单
        OrderInfo orderInfo = seckillService.seckill(user, goods);

        return Result.success(orderInfo);
    }

    // 系统初始化，预加载秒杀商品库存
    @Override
    public void afterPropertiesSet() throws Exception {
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        if (goodsList == null) {
            return;
        }
        for (GoodsVo goods : goodsList) {
            System.out.println("将goods库存存入redis中");
            System.out.println(goods.toString());
            redisService.set(GoodsKey.getSeckillGoodsStock, String.valueOf(goods.getId()), goods.getStockCount());
            localOverMap.put(goods.getId(), false);
        }
    }

    @RequestMapping(value = "/{path}/better", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> betterSeckill(HttpServletRequest request, Model model, SecKillUser user,
                                         @RequestParam("goodsId") long goodsId,
                                         @RequestParam("inputCode") String inputCode,
                                         @PathVariable("path") String path) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        // 验证验证码
        String rightCode = (String) request.getSession().getAttribute("rightCode");
        if (!rightCode.equals(inputCode)) {
            return Result.error(CodeMsg.VERIFY_FAILED);
        }
        // 验证path
        boolean isChecked = seckillService.checkPath(user, goodsId, path);
        if (!isChecked) {
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        // 内存标记，减少redis访问
        Boolean over = localOverMap.get(goodsId);
        if (over) {
            return Result.error(CodeMsg.SECKILL_OVER);
        }
        // 判断是否已经秒杀到了
        SeckillOrder order = orderService.getSeckillOrderByUserIdAndGoodsId(user.getId(), goodsId);
        if (order != null) {
            return Result.error(CodeMsg.REPEATE_SECKILL);
        }
        // 预减库存
        long stock = redisService.decr(GoodsKey.getSeckillGoodsStock, String.valueOf(goodsId));
        if(stock < 0) { // 注意这里是小于0，当剩下1个商品时，此时有用户下单，并锁定该商品，预减库存后stock=0，下次再有用户下单stock=-1，此时是下单不成功的
            localOverMap.put(goodsId, true);
            return Result.error(CodeMsg.SECKILL_OVER);
        }
        // 入队
        SeckillMessage sm = new SeckillMessage();
        sm.setUser(user);
        sm.setGoodsId(goodsId);
        sender.send(sm);

        return Result.success("秒杀成功");
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public Result<Long> seckillResult(Model model, SecKillUser user, @RequestParam("goodsId") long goodsId) {
        model.addAttribute("user", user);
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        long result = seckillService.getSeckillResult(user.getId(), goodsId);

        return Result.success(result);
    }

    @AccessLimit(seconds = 5, maxCount = 5, needLogin = true)
    @RequestMapping(value = "/path", method = RequestMethod.GET)
    @ResponseBody
    public Result<String> getSeckillPath(SecKillUser user, @RequestParam("goodsId") long goodsId) {
        String path = seckillService.createSeckillPath(user, goodsId);
        return Result.success(path);
    }
}
