package com.zhonghuasheng.seckill.redis;

public interface KeyPrefix {

    int expireSeconds();
    String getPrefix();
}
