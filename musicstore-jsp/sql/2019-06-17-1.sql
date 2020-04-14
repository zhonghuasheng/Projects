CREATE DATABASE `musicstore-jsp` /*!40100 DEFAULT CHARACTER SET utf8 */;

use `musicstore-jsp`;

CREATE TABLE `user_` (
  `uuid` varchar(36) NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` enum('ADMIN','USER') NOT NULL DEFAULT 'USER',
  `birthday` date DEFAULT NULL,
  `gender` enum('MALE','FEMALE','UNKNOW') DEFAULT 'UNKNOW',
  `avatar` varchar(45) DEFAULT NULL,
  `active` tinyint(4) NOT NULL,
  `deleted` tinyint(4) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  `last_modified_by` varchar(36) NOT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `uuid` (`uuid`),
  KEY `uuid_email` (`uuid`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `artist` (
  `uuid` varchar(36) NOT NULL,
  `name` varchar(45) NOT NULL,
  `birthday` date DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `experience` text,
  `avatar` varchar(45) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  `last_modified_by` varchar(36) NOT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`uuid`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='艺术家表';

CREATE TABLE `address` (
  `uuid` varchar(36) NOT NULL,
  `user_uuid` varchar(36) NOT NULL,
  `addressee` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `province` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `region` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `default` tinyint(4) DEFAULT '1',
  `create_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  KEY `fk_address_user_idx` (`user_uuid`),
  CONSTRAINT `fk_address_user` FOREIGN KEY (`user_uuid`) REFERENCES `user_` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址表';

CREATE TABLE `music` (
  `uuid` varchar(36) NOT NULL,
  `title` varchar(45) NOT NULL,
  `avatar` varchar(45) NOT NULL,
  `artist_uuid` varchar(36) NOT NULL,
  `publish_date` date NOT NULL,
  `publish_company` varchar(45) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  `last_modified_by` varchar(36) NOT NULL,
  `is_deleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  KEY `fk_music_artist_idx` (`artist_uuid`),
  CONSTRAINT `fk_music_artist` FOREIGN KEY (`artist_uuid`) REFERENCES `artist` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='音乐表';

CREATE TABLE `cart` (
  `uuid` varchar(36) NOT NULL,
  `user_uuid` varchar(36) NOT NULL,
  `music_uuid` varchar(36) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  KEY `fk_idx` (`user_uuid`),
  KEY `fk_cart_music_idx` (`music_uuid`),
  CONSTRAINT `fk_cart_music` FOREIGN KEY (`music_uuid`) REFERENCES `music` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_user` FOREIGN KEY (`user_uuid`) REFERENCES `user_` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

CREATE TABLE `order` (
  `uuid` varchar(36) NOT NULL,
  `user_uuid` varchar(36) NOT NULL,
  `music_uuid` varchar(36) NOT NULL,
  `address_uuid` varchar(36) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  `last_modified_by` varchar(36) NOT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  KEY `fk_order_user_idx` (`user_uuid`),
  KEY `fk_order_music_idx` (`music_uuid`),
  KEY `fk_order_address_idx` (`address_uuid`),
  CONSTRAINT `fk_order_address` FOREIGN KEY (`address_uuid`) REFERENCES `address` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_music` FOREIGN KEY (`music_uuid`) REFERENCES `music` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_uuid`) REFERENCES `user_` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

CREATE TABLE `order_status` (
  `uuid` varchar(36) NOT NULL,
  `order_uuid` varchar(36) DEFAULT NULL,
  `status` enum('paid','sent','received','finished') DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  `last_modifed_by` varchar(36) NOT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  KEY `fk_order_status_order_idx` (`order_uuid`),
  CONSTRAINT `fk_order_status_order` FOREIGN KEY (`order_uuid`) REFERENCES `order` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单状态表';

CREATE TABLE `message` (
  `uuid` varchar(36) NOT NULL,
  `from` varchar(45) NOT NULL,
  `to` varchar(36) NOT NULL COMMENT 'user uuid',
  `title` varchar(45) NOT NULL,
  `context` text NOT NULL,
  `status` enum('read','unread') DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  KEY `fk_message_user_idx` (`to`),
  CONSTRAINT `fk_message_user` FOREIGN KEY (`to`) REFERENCES `user_` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';
