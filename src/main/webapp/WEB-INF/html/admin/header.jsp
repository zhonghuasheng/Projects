<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          <!--鼠标放在头像上的下拉框-->
          <div class="b">
            <a href="#">我的资料</a>
            <a href="#">注销</a>
          </div>
        </div>

        <div class="icons f-right">
          <i class="fa fa-commenting-o" aria-hidden="true"></i>
          <!--从图标官网找图标引用语句复制下来 -->
          <span class="info">5 </span>  <!--比如5条消息-->
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
              <span>Dashboard</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-artist" href="<%=basePath%>/admin/artist">
              <i class="fa"></i>
              <span>Artist</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-music" href="#2">
              <i class="fa"></i>
              <span>Music</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-user" href="<%=basePath%>/admin/user">
              <i class="fa"></i>
              <span>User</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-order" href="#2">
              <i class="fa"></i>
              <span>Order</span>
            </a>
          </li>
          <li>
            <a class="menu-item menu-message" href="#2">
              <i class="fa"></i>
              <span>Message</span>
            </a>
          </li>
        </ul>
      </div>
  </body>
</html>