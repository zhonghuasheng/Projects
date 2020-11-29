## 音乐商店平台
### 目录
* [01-项目立项](#01-项目立项)
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