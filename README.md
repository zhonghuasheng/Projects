# Music Store(音乐商店) - JSP + Servlet + JDBC + MySQL版本
[![Build Status](https://travis-ci.org/zhonghuasheng/musicstore-jsp.svg?branch=master)](https://travis-ci.org/zhonghuasheng/musicstore-jsp)
## `前言`
Music Store是微软的一个开源项目，旨在通过一步步的教程帮助.NET学习者快速搭建一个ASP.NET MVC的项目。大学期间我通过学习，在2天内搭建了这个项目，作为模板供老师教学使用。现在已经毕业几年了，对软件开发有了新的认识，想以Music Store项目为蓝本，打造一个Java版本的Music Store。

## `项目描述`
音乐商店，不只是音乐，更多的是技术的融合；音乐商店是一个很简单的业务的缩影，包含了常用技术的体现。让我们慢慢雕琢，像雕琢自己一样。

**需求就是这么简单**

音乐商店管理员可以通过后台添加艺术家，添加音乐，对艺术家和音乐能够进行管理，也可以管理普通用户和他们的订单。

普通用户注册后，登陆音乐商店，完善个人信息，选购自己喜欢的音乐加入购物车，然后去购物车结账。

## `项目计划`
### `版本计划`
* V1: Music Store(音乐商店) - JSP + Servlet + JDBC + MySQL版本
* V2: Music Store(音乐商店) - Spring + SpringMVC + MyBatis + MySQL版本
* V3: Music Store(音乐商店) - SpringBoot + MyBatis + MySQL + APP版本
* V4: Music Store(音乐商店) - SpringCloud + MySQL + APP版本

### 功能计划
![](requirement/musicstore-jsp-2019-08-03.png)

## 项目实施
### 开发技术选型

 | 技术 | 说明 | 官方网址 |
 |:---- |:--------- |:-------|
 | JSP |前端页面 | https://www.tutorialspoint.com/jsp/ |
 | Bootstrap | 前端样式 | https://getbootstrap.com/ |
 | Font Awesome | 前端图标样式库 | https://fontawesome.com |
 | Tomcat 8 | 服务器 | https://tomcat.apache.org/download-80.cgi |
 | Java 8 | 后端代码开发语言 | https://www.oracle.com |

### 项目结构

### 数据库设计
 | 表名 | 说明 |
 |:---- |:-----|
 | user_ | 用户表 |
 | artist | 艺术家表 |
 | music | 音乐表 |
 | cart | 购物车表 |
 | address | 地址表 |
 | order | 订单表 |
 | order_status | 订单状态表 |
 | message | 消息表 |
![](sql/musicstore_jsp_database_diagram.png)

## `进度安排`
* [Story #0: 项目需求分析、功能描述、技术选型、数据库设计、框架搭建](https://github.com/zhonghuasheng/musicstore-jsp/issues/22)
* [Story #1: 管理员能够登陆后端系统](https://github.com/zhonghuasheng/musicstore-jsp/issues/1)
* [Story #2: 管理员能够对艺术家进行增删改查](https://github.com/zhonghuasheng/musicstore-jsp/issues/6)
* [Story #3: 管理员能够对音乐进行增删改查](https://github.com/zhonghuasheng/musicstore-jsp/issues/7)
* [Story #4: 普通用户能够使用邮箱注册音乐商店](https://github.com/zhonghuasheng/musicstore-jsp/issues/8)
* [Story #5: 普通用户能够登陆音乐商店](https://github.com/zhonghuasheng/musicstore-jsp/issues/9)
* [Story #6: 普通用户登陆之后进入音乐商店首页，参考首页设计](https://github.com/zhonghuasheng/musicstore-jsp/issues/10)
* [Story #7: 普通用户能够查看艺术家以及艺术家对应的音乐专辑](https://github.com/zhonghuasheng/musicstore-jsp/issues/11)
* [Story #8: 普通用户能够查看音乐详情](https://github.com/zhonghuasheng/musicstore-jsp/issues/12)
* [Story #9: 普通用户能够添加音乐到购物车](https://github.com/zhonghuasheng/musicstore-jsp/issues/13)
* [Story #10: 普通用户对自己的送货地址进行管理](https://github.com/zhonghuasheng/musicstore-jsp/issues/14)
* [Story #11: 普通用户可以选择购物车中的商品进行下单](https://github.com/zhonghuasheng/musicstore-jsp/issues/15)
* [Story #12: 管理员能够对普通用户进行管理](https://github.com/zhonghuasheng/musicstore-jsp/issues/16)
* [Story #13: 管理员能够对订单进行管理](https://github.com/zhonghuasheng/musicstore-jsp/issues/17)

## 项目进度管理
[点击此处进度查看](https://github.com/zhonghuasheng/musicstore-jsp/projects/1)

![](requirement/project_progress_management_dashboard.PNG)

# 参看文档
[Tomcat 配置上传文件到项目外的路径](https://www.cnblogs.com/yjq520/p/7884656.html)
