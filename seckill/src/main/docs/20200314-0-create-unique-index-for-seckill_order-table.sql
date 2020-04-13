alter table seckill_order comment '通过数据库唯一索引的方式解决超卖为题，每个人对于一件商品只能有一份订单';
create unique index user_order__index on seckill_order (user_id, goods_id);
