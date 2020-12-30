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

* druid监控界面 http://localhost:8080/druid/index.html
* admin管理界面 http://localhost:1010/login

### 技术点跟踪
* [20201130-MyBatisPlus实现多数据源，自己写了个例子](https://github.com/zhonghuasheng/Tutorial/blob/master/plugins/mybatis-plus.md)
* [20201201-MyBatisPlus Dynamic Datasource与Druid连接池一起使用时报错]
```
Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
问题的原因时Dynamic Source和Druid中都有关于数据源的自动配置，导致springboot启动时不知道选哪个，如下博客解决了这个问题
https://blog.csdn.net/nsplnpbjy/article/details/106377110
```
* [20201201-Druid中使用log4j2进行日志输出](https://github.com/alibaba/druid/wiki/Druid%E4%B8%AD%E4%BD%BF%E7%94%A8log4j2%E8%BF%9B%E8%A1%8C%E6%97%A5%E5%BF%97%E8%BE%93%E5%87%BA)
```
报错： Spring Boot与Log4j2集成之java.lang.IllegalStateException: Logback configuration error detected:
问题的原因是各spring-boot-starter中都可能含有logging，一般的做法是移除web中的，但是移除不干净
https://blog.csdn.net/blueheart20/article/details/78111350
```
* [20201225-添加ms-config中的profile]()
```
TODO 我的想法是parent pom中控制版本号，然后子module都会按照此版本号生成对应的jar
```
* [20201229-集成gateway时报SLF4J: Class path contains multiple SLF4J bindings.]
```
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/C:/Users/Ant/.m2/repository/org/apache/logging/log4j/log4j-slf4j-impl/2.13.3/log4j-slf4j-impl-2.13.3.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/C:/Users/Ant/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.apache.logging.slf4j.Log4jLoggerFactory]
原因：spring-boot/cloud的各种starter都集成了内置logging，在pom中使用execultion移除掉即可
```
* [20201230-解决config,gateway,user中配置文件的先后顺序问题]
```
1. properties比yml配置文件的优先级高，bootstrap优先级比application优先级高，config中同级别的配置文件比module中的高
2. nacos在项目启动的时候就去找配置文件了，所以nacos的配置在module中【module中使用bootstrap.yml级别】，并且变量要先获取到【变量放到bootstrap.properties中】
```