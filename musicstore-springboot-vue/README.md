# Music Store(音乐商店) - SpringCloud Alibaba + MyBatis + Redis + RabbitMQ + MySQL + ELK + Kafka + Hive + Vue版本
[![Build Status](https://travis-ci.org/zhonghuasheng/musicstore-jsp.svg?branch=master)](https://travis-ci.org/zhonghuasheng/musicstore-jsp)
## `前言`
Music Store是微软的一个开源项目，旨在通过一步步的教程帮助.NET学习者快速搭建一个ASP.NET MVC的项目。大学期间我通过学习，在2天内搭建了这个项目，作为模板供老师教学使用。现在已经毕业几年了，对软件开发有了新的认识，想以Music Store项目为蓝本，已经做了一个JSP+Servlet的版本，直接跳过了SpringBoot版本，这个项目是打造一个Java微服务版本的Music Store。

## `项目描述`
音乐商店，不只是音乐，更多的是技术的融合；音乐商店是一个很简单的业务的缩影，包含了常用技术的体现。让我们慢慢雕琢，像雕琢自己一样。

**需求就是这么简单**

商家可以上架在线的音乐，也可以上架唱片这样的实质货物，在线的音乐没有库存概念，唱片有库存概念

用户可以在线浏览和查看音乐，把喜欢的音乐加入购物车，然后可以结算，下单，商家收到订单后寄送

系统记录用户的点击数据，根据统计的结果给用户推荐

用户可以对音乐做出评论

系统的搜索包含歌曲名，作者，歌词

## `项目计划`
### `版本计划`
* V1: Music Store(音乐商店) - JSP + Servlet + JDBC + MySQL版本 - `完成`
* V2: Music Store(音乐商店) - Spring + SpringMVC + MyBatis + MySQL版本 - `跳过`
* V3: Music Store(音乐商店) - SpringBoot + MyBatis + MySQL + APP版本 - `跳过`
* V4: Music Store(音乐商店) - SpringCloud Alibaba + MyBatis + Redis + RabbitMQ + MySQL + ELK + Kafka + Hive + Vue版本

## 音乐商店平台
### 目录
* [01-项目立项](ms-doc/requirement/01-项目立项.md)
* [02-框架搭建](#02-框架搭建)
* [03-数据库设计](#03-数据库设计)

* 本项目是基于musicstore-jsp项目，结合当下流行的springcloud技术，而开发的脚手架
```
-- ms-platform 音乐商店平台服务
  -- ms-common 通用模块starter
    -- ms-security-spring-boot-starter 安全组件starter
    -- ms-db-spring-boot-starter 数据库组件starter
    -- ms-redis-spring-boot-starter 缓存组件starter
    -- ms-core-spring-boot-starter 核心类组件starter
  -- ms-business 业务模块
    -- ms-biz-model Model类（DTO, VO, PO）
    -- ms-biz-user 用户服务
    -- ms-biz-product 产品服务
    -- ms-biz-activity 活动服务
    -- ms-biz-order 订单服务
    -- ms-biz-stock 库存服务
  -- ms-config 配置模块
  -- ms-gateway 网关模块
  -- ms-plugins 中间件模块
  -- ms-test 测试模块
  -- ms-bigdata 大数据模块
    -- ms-search 搜索服务
    -- ms-recommend 推荐服务
  -- ms-admin 店铺后台
  -- ms-job 定时任务模块
  -- ms-administrator 系统管理模块
```