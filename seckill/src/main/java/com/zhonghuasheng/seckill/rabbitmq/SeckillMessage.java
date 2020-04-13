package com.zhonghuasheng.seckill.rabbitmq;

import com.zhonghuasheng.seckill.domain.SecKillUser;

public class SeckillMessage {

    private SecKillUser user;
    private long goodsId;

    public SecKillUser getUser() {
        return user;
    }

    public void setUser(SecKillUser user) {
        this.user = user;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }
}
