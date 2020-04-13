package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.common.Result;
import com.zhonghuasheng.seckill.domain.SecKillUser;
import com.zhonghuasheng.seckill.redis.GoodsKey;
import com.zhonghuasheng.seckill.redis.RedisService;
import com.zhonghuasheng.seckill.service.GoodsService;
import com.zhonghuasheng.seckill.vo.GoodsDetailVo;
import com.zhonghuasheng.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;
    @Autowired
    RedisService redisService;

    // 商品列表
    @RequestMapping(value = {"", "/"}, produces = "text/html")
    @ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response, Model model, SecKillUser user) {
        model.addAttribute("user", user);
        // 取缓存
        String html = redisService.get(GoodsKey.getGoodsList, "", String.class);
        if (!StringUtils.isEmpty(html)) {
            return html;
        }

        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);
        // 手动渲染
        WebContext context = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goods_list", context);
        if (!StringUtils.isEmpty(html)) {
            redisService.set(GoodsKey.getGoodsList, "", html);
        }

        return html;
    }

    // 商品详情: 页面缓存到redis
    @RequestMapping(value = "/detail/{id}", produces = "text/html")
    public String detail(HttpServletRequest request, HttpServletResponse response, Model model, SecKillUser user, @PathVariable("id") long id) {
        model.addAttribute("user", user);
        // 取缓存
        String html = redisService.get(GoodsKey.getGoodsDetail, String.valueOf(id), String.class);
        if (!StringUtils.isEmpty(html)) {
            return html;
        }
        // 手动渲染
        GoodsVo goods = goodsService.getById(id);
        model.addAttribute("goods", goods);

        long startTime = goods.getStartDate().getTime();
        long endTime = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int seckillStatus = 0;
        int remainSeconds = 0;

        if ( now < startTime ) {
            seckillStatus = 0;
            remainSeconds = (int) ((startTime - now) / 1000);
        } else if (now > endTime) {
            seckillStatus = 2;
            remainSeconds = -1;
        } else {
            seckillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("seckillStatus", seckillStatus);
        model.addAttribute("remainSeconds", remainSeconds);

        WebContext context = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goods_detail", context);
        if (!StringUtils.isEmpty(html)) {
            redisService.set(GoodsKey.getGoodsDetail, String.valueOf(id), html);
        }

        return html;
    }

    // 商品详情: 页面静态化
    @RequestMapping(value = "/details/{id}")
    @ResponseBody
    public Result<GoodsDetailVo> details(Model model, SecKillUser user, @PathVariable("id") long id) {
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.getById(id);
        long startTime = goods.getStartDate().getTime();
        long endTime = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int seckillStatus = 0;
        int remainSeconds = 0;

        if ( now < startTime ) {
            seckillStatus = 0;
            remainSeconds = (int) ((startTime - now) / 1000);
        } else if (now > endTime) {
            seckillStatus = 2;
            remainSeconds = -1;
        } else {
            seckillStatus = 1;
            remainSeconds = 0;
        }

        GoodsDetailVo vo = new GoodsDetailVo();
        vo.setSeckillStatus(seckillStatus);
        vo.setRemainSeconds(remainSeconds);
        vo.setUser(user);
        vo.setGoods(goods);

        return Result.success(vo);
    }
}
