package com.zhonghuasheng.seckill.rabbitmq;

import com.zhonghuasheng.seckill.domain.SecKillUser;
import com.zhonghuasheng.seckill.domain.SeckillOrder;
import com.zhonghuasheng.seckill.redis.RedisService;
import com.zhonghuasheng.seckill.service.GoodsService;
import com.zhonghuasheng.seckill.service.OrderService;
import com.zhonghuasheng.seckill.service.SeckillService;
import com.zhonghuasheng.seckill.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);

    @Autowired
    AmqpTemplate amqpTemplate;
    @Autowired
    RedisService redisService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderService orderService;
    @Autowired
    SeckillService seckillService;

    @RabbitListener(queues = MQConfig.SECKILL_QUEUE_NAME)
    public void receive(String message) {
        System.out.println("消费者接收到消息：");
        log.info(message);
        SeckillMessage sm = redisService.stringToBean(message, SeckillMessage.class);
        SecKillUser user = sm.getUser();
        long goodsId = sm.getGoodsId();

        GoodsVo goods = goodsService.getById(goodsId);
        if (goods.getStockCount() < 0) {
            return;
        }
        // 判断是否已经秒杀到了
        SeckillOrder order = orderService.getSeckillOrderByUserIdAndGoodsId(user.getId(), goodsId);
        if (order != null) {
            return;
        }
        // 减库存 下订单 写入秒杀订单
        seckillService.seckill(user, goods);
    }
}
