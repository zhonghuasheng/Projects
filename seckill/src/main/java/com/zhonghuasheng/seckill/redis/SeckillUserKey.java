package com.zhonghuasheng.seckill.redis;

public class SeckillUserKey extends BasePrefix {


    private static final int TOKEN_EXPIRE = 172800;
    public static SeckillUserKey token = new SeckillUserKey(TOKEN_EXPIRE, "tk");

    public SeckillUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
