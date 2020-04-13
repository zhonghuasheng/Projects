-- 商品表
CREATE TABLE goods(
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  goods_name VARCHAR(16) DEFAULT NULL COMMENT '商品名称',
  goods_title VARCHAR(64) DEFAULT NULL COMMENT '商品名称',
  goods_img VARCHAR(64) DEFAULT NULL COMMENT '商品图片',
  goods_detail LONGTEXT COMMENT '商品详情介绍',
  goods_price DECIMAL(10, 2) DEFAULT '0.00' COMMENT '商品价格',
  goods_stock INT(11) DEFAULT '0' COMMENT '商品库存，-1表示没有限制',
  PRIMARY KEY(id)
) DEFAULT CHARSET=UTF8;

INSERT INTO goods VALUES
(1, 'iphoneX', 'Apple iPhone X(A1865) 64GB银色 移动联通电信4G手机', '/img/iphonex.png', 'Apple iPhone X(A1865) 64GB银色 移动联通电信4G手机', 8765.00, 10000),
(2, '华为Mate10', '华为Mate10 8G+128G版 月光银 移动联通电信5G手机', '/img/meta10.png', '华为Mate10 8G+128G版 月光银 移动联通电信5G手机', 8888.00, -1)

-- 秒杀商品表
CREATE TABLE seckill_goods(
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  goods_id BIGINT(20) DEFAULT NULL COMMENT '',
  seckill_price DECIMAL(10, 2) DEFAULT '0.00' COMMENT '',
  stock_count INT(11) DEFAULT NULL COMMENT '',
  start_date DATETIME DEFAULT NULL COMMENT '',
  end_date DATETIME DEFAULT NULL COMMENT '',
  PRIMARY KEY(id)
) DEFAULT CHARSET=UTF8;

INSERT INTO seckill_goods VALUES
(1, 1, 0.01, 4, '2020-03-10 12:00:00', '2020-03-12 12:00:00'),
(2, 2, 0.01, 9, '2020-03-10 11:00:00', '2020-03-12 12:00:00')

CREATE TABLE order_info(
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  user_id BIGINT(20) DEFAULT NULL COMMENT '用户ID',
  goods_id BIGINT(20) DEFAULT NULL COMMENT '商品ID',
  delivery_addr_id BIGINT(20) DEFAULT NULL COMMENT '收货地址ID',
  goods_name VARCHAR(16) DEFAULT NULL COMMENT '冗余过来的商品名',
  goods_count INT(11) DEFAULT '0' COMMENT '商品数量',
  goods_price DECIMAL(10, 2) DEFAULT '0.00' COMMENT '商品单价',
  order_channel TINYINT(4) DEFAULT '0' COMMENT '1pc, 2android, 3ios',
  status TINYINT(4) DEFAULT '0' COMMENT '订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成',
  create_date DATETIME DEFAULT NULL COMMENT '订单创建时间',
  pay_date DATETIME DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY(id)
) DEFAULT CHARSET=UTF8;

CREATE TABLE seckill_order(
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  user_id BIGINT(20) DEFAULT NULL COMMENT '用户ID',
  order_id BIGINT(20) DEFAULT NULL COMMENT '订单ID',
  goods_id BIGINT(20) DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY(id)
) DEFAULT CHARSET=UTF8;