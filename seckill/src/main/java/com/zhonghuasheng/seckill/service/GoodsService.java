package com.zhonghuasheng.seckill.service;

import com.zhonghuasheng.seckill.dao.GoodsDao;
import com.zhonghuasheng.seckill.domain.SeckillGoods;
import com.zhonghuasheng.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public List<GoodsVo> listGoodsVo() {
        return goodsDao.listGoodsVo();
    }

    public GoodsVo getById(long id) {
        return goodsDao.getById(id);
    }

    public boolean reduceStock(long goodsId) {
        return goodsDao.reduceStock(goodsId) > 0;
    }
}
