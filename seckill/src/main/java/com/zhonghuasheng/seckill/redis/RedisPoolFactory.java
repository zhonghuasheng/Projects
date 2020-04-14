package com.zhonghuasheng.seckill.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisPoolFactory {

    @Autowired
    RedisConfig redisConfig;

    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getMaxIdle());
        poolConfig.setMaxWaitMillis(redisConfig.getMaxWait());

        JedisPool jedisPool = new JedisPool(poolConfig,
                redisConfig.getHost(),
                redisConfig.getPort(),
                redisConfig.getTimeout(),
                redisConfig.getPssword(),
                redisConfig.getDatabase());

        return jedisPool;
    }
}
