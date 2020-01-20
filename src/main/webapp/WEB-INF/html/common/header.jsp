<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String baseP = request.getContextPath();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=baseP%>/static/bootstrap/css/bootstrap.css" />
    <script src="<%=baseP%>/static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=baseP%>/static/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=baseP%>/static/css/home.css" />
    <link rel="stylesheet" href="<%=baseP%>/static/fontawesome/css/font-awesome.min.css" />
  </head>
  <body>
      <div class="head">
        <div class="logo wd-2">
          <h2>
            <img src="<%=baseP%>/static/image/music.png">
            <a>音乐商店</a>
          </h2>
        </div>
        <div class="wd-1">
          <div>发现音乐</div>
        </div>
        <div class="wd-1">
          <div>音乐人</div>
        </div>
        <div class="wd-1">
          <div>我的音乐</div>
        </div>
        <div class="wd-25">
          <div class="search-box">
            <input type="text" name="srch" id="srch" class="search-box" placeholder="音乐/艺人" value="" style="opacity: 1;">
          </div>
        </div>
        <div class="wd-25 flex-right">
          <a href="<%=baseP%>/register">注册</a>
          <a>/</a>
          <a href="<%=baseP%>/login">登陆</a>
        </div>
      </div>
      <div class="subnav-middle"></div>
  </body>
</html>