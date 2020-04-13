package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.common.Result;
import com.zhonghuasheng.seckill.domain.OrderInfo;
import com.zhonghuasheng.seckill.service.GoodsService;
import com.zhonghuasheng.seckill.service.OrderService;
import com.zhonghuasheng.seckill.vo.GoodsVo;
import com.zhonghuasheng.seckill.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    GoodsService goodsService;


    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(@RequestParam("orderId") long orderId) {
        OrderInfo order = orderService.getOrderInfoById(orderId);
        if (order == null) {
            return Result.error(CodeMsg.ORDER_NOT_EXIST);
        }
        GoodsVo goods = goodsService.getById(order.getGoodsId());
        OrderDetailVo vo = new OrderDetailVo();
        vo.setOrder(order);
        vo.setGoods(goods);

        return Result.success(vo);
    }
}
