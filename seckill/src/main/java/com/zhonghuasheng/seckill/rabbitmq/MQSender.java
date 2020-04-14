package com.zhonghuasheng.seckill.rabbitmq;

import com.zhonghuasheng.seckill.redis.RedisService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSender {

    @Autowired
    AmqpTemplate amqpTemplate;
    @Autowired
    RedisService redisService;

    public void send(SeckillMessage message) {
        String msg = redisService.beanToString(message);
        System.out.println("send msg:" + msg);
        amqpTemplate.convertAndSend(MQConfig.SECKILL_QUEUE_NAME, msg);
    }
}
