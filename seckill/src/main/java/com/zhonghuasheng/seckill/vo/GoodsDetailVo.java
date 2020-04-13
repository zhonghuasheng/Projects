package com.zhonghuasheng.seckill.vo;

import com.zhonghuasheng.seckill.domain.SecKillUser;

public class GoodsDetailVo {

    private int seckillStatus;
    private int remainSeconds;
    private GoodsVo goods;
    private SecKillUser user;

    public int getSeckillStatus() {
        return seckillStatus;
    }

    public void setSeckillStatus(int seckillStatus) {
        this.seckillStatus = seckillStatus;
    }

    public int getRemainSeconds() {
        return remainSeconds;
    }

    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }

    public GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }

    public SecKillUser getUser() {
        return user;
    }

    public void setUser(SecKillUser user) {
        this.user = user;
    }
}
