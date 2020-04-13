package com.zhonghuasheng.seckill.service;

import com.zhonghuasheng.seckill.dao.OrderDao;
import com.zhonghuasheng.seckill.domain.OrderInfo;
import com.zhonghuasheng.seckill.domain.SecKillUser;
import com.zhonghuasheng.seckill.domain.SeckillOrder;
import com.zhonghuasheng.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public SeckillOrder getSeckillOrderByUserIdAndGoodsId(Long userId, long goodsId) {
        return orderDao.getSeckillOrderByUserIdAndGoodsId(userId, goodsId);
    }

    @Transactional
    public OrderInfo createOrder(SecKillUser user, GoodsVo goods) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsPrice(goods.getGoodsPrice());
        orderInfo.setPayDate(new Date());
        orderInfo.setStatus(0);
        orderInfo.setUserId(user.getId());
        orderInfo.setOrderChannel(1);
        orderDao.insert(orderInfo); // 插入数据库后回填orderInfo的id值，@SelectKey

        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setGoodsId(goods.getId());
        seckillOrder.setOrderId(orderInfo.getId());
        seckillOrder.setUserId(user.getId());
        orderDao.insertSeckillOrder(seckillOrder);

        return orderInfo;
    }

    public OrderInfo getOrderInfoById(long orderId) {
        return orderDao.getOrderInfoById(orderId);
    }
}
