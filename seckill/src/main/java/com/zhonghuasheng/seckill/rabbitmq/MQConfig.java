package com.zhonghuasheng.seckill.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String SECKILL_QUEUE_NAME = "seckill.queue";

    @Bean
    public Queue queue() {
        return new Queue(SECKILL_QUEUE_NAME, true); // queueName, durable是持久化
    }
}
