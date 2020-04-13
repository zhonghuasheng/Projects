package com.zhonghuasheng.seckill.dao;

import com.zhonghuasheng.seckill.domain.OrderInfo;
import com.zhonghuasheng.seckill.domain.SeckillOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface OrderDao {

    @Select("SELECT * FROM seckill_order WHERE user_id = #{userId} AND goods_id = #{goodsId}")
    SeckillOrder getSeckillOrderByUserIdAndGoodsId(long userId, long goodsId);

    @Insert("INSERT INTO order_info(user_id, goods_id, delivery_addr_id, goods_name, goods_count," +
            " goods_price, order_channel, status, create_date, pay_date) VALUES(#{userId}, #{goodsId}," +
            " #{deliveryAddrId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel}, #{status}," +
            " #{createDate}, #{payDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Long.class, before = false, statement = "SELECT last_insert_id()")
    long insert(OrderInfo orderInfo); // selectKey是主键回填

    @Insert("INSERT INTO seckill_order(user_id, order_id, goods_id) VALUES (#{userId}, #{orderId}, #{goodsId})")
    int insertSeckillOrder(SeckillOrder seckillOrder);

    @Select("SELECT * FROM order_info WHERE id = #{orderId}")
    OrderInfo getOrderInfoById(long orderId);
}
