package com.zhonghuasheng.seckill.dao;

import com.zhonghuasheng.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("SELECT g.*, s.seckill_price, s.stock_count, s.start_date, s.end_date FROM goods AS g LEFT JOIN seckill_goods AS s ON g.id = s.id")
    List<GoodsVo> listGoodsVo();

    @Select("SELECT g.*, s.seckill_price, s.stock_count, s.start_date, s.end_date FROM goods AS g LEFT JOIN seckill_goods AS s ON g.id = s.id WHERE g.id = #{id}")
    GoodsVo getById(@Param("id") long id);

    @Update("UPDATE seckill_goods SET stock_count = stock_count - 1 WHERE goods_id = #{goodsId} AND stock_count > 0")
    int reduceStock(@Param("goodsId") long goodsId);
}
