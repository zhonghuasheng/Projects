<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePath = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Admin Portal</title>
    <link rel="stylesheet" href="<%=basePath%>/static/fontawesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/admin-management.css" />
  </head>
    <body>
      <div class="pg-header">
        <div class="logo f-left">
          MusicStore
        </div>

        <div class="user f-right">
          <a class="a fa fa-user fa-fw" href="#"></a>
          <div class="b">
            <a href="#">我的资料</a>
            <a href="#">注销</a>
          </div>
        </div>

        <div class="icons f-right">
          <i class="fa fa-commenting-o" aria-hidden="true"></i>
          <span class="info">5 </span>
        </div>
        <div class="icons f-right">
          <i class="fa fa-bell-o" aria-hidden="true"></i>
        </div>
      </div>

      <div class="menu f-left">
        <ul>
          <li>
            <a class="menu-item menu-item-active menu-dashboard" href="#1">
              <i class="fa"></i>
              <span>首页</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-artist" href="<%=basePath%>/admin/artist">
              <i class="fa"></i>
              <span>艺术家</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-music" href="#2">
              <i class="fa"></i>
              <span>音乐</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-user" href="<%=basePath%>/admin/user">
              <i class="fa"></i>
              <span>用户</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-order" href="#2">
              <i class="fa"></i>
              <span>订单</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-message" href="#2">
              <i class="fa"></i>
              <span>消息</span>
            </a>
          </li>
        </ul>
      </div>
  </body>
</html>