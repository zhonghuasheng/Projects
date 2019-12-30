<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePath = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap/css/bootstrap.css" />
    <script src="<%=basePath%>/static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>/static/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/home.css" />
  </head>
  <body>
    <div class="body">
      <div class="head"></div>
      <div class="subnav-middle"></div>
      <div class="content">
        <div id="carousel-part" class="carousel slide" data-ride="carousel">
          <!-- 指示符 -->
          <ul class="carousel-indicators">
            <li data-target="#carousel-part" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-part" data-slide-to="1"></li>
            <li data-target="#carousel-part" data-slide-to="2"></li>
          </ul>

          <!-- 轮播图片 -->
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="http://static.runoob.com/images/mix/img_fjords_wide.jpg">
            </div>
            <div class="carousel-item">
              <img src="http://static.runoob.com/images/mix/img_nature_wide.jpg">
            </div>
            <div class="carousel-item">
              <img src="http://static.runoob.com/images/mix/img_mountains_wide.jpg">
            </div>
          </div>

          <!-- 左右切换按钮 -->
          <a class="carousel-control-prev" href="#carousel-part" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
          </a>
          <a class="carousel-control-next" href="#carousel-part" data-slide="next">
            <span class="carousel-control-next-icon"></span>
          </a>
        </div>
      </div>

      <div class="recommend wd-8">
        <div class="recommend-music">
          <div class="title">每日热歌</div>
          <div class="subnav-small"></div>
          <div class="recommend-li">
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
          </div>
        </div>
        <div class="recommend-artist">
          <div class="title">艺人推荐</div>
          <div class="subnav-small"></div>
          <div class="recommend-li">
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
            <div class="recommend-item"></div>
          </div>
        </div>
        <div class="recommend">
          <div class="title">猜你喜欢</div>
          <div class="subnav-small"></div>
          <div class="recommend-li">
                      <div class="recommend-item"></div>
                      <div class="recommend-item"></div>
                      <div class="recommend-item"></div>
                      <div class="recommend-item"></div>
                      <div class="recommend-item"></div>
                    </div>
        </div>
      </div>
      <div class="footer">
        <div class="wd-8">
        <span>Music Store©2019 Copyright</span>
        <span class="float-right">个人学习项目 Powered by
          <a href="https://github.com/zhonghuasheng">种花生的读书人</a>
        </span>
      </div>
    </div>
  </body>
</html>