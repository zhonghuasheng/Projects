<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
String basePaths = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePaths%>/static/bootstrap/css/bootstrap.css" />
    <script src="<%=basePaths%>/static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePaths%>/static/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePaths%>/static/css/home.css" />
    <link rel="stylesheet" href="<%=basePaths%>/static/fontawesome/css/font-awesome.min.css" />
    <style type="text/css">
        .dropdown:hover>.dropdown-menu {
            display: block;
        }
        .dropdown>.dropdown-toggle:active {
            pointer-events: none;
        }
    </style>
  </head>
  <body>
     <div class="head">
       <div class="logo wd-2">
         <h2>
           <img src="<%=basePaths%>/static/image/music.png">
           <a>音乐商店</a>
         </h2>
       </div>
       <div class="wd-1">
         <div><a href="<%=basePaths%>/home" style="color: white;">发现音乐</a></div>
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
          <c:choose>
            <c:when test="${sessionScope.user==null }">
              <a href="<%=basePaths%>/register">注册</a><a href="###">/</a><a href="<%=basePaths%>/login">登陆</a>
            </c:when>
            <c:otherwise>
              <div class="dropdown">
                <button class="btn" style="color: white;" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  ${sessionScope.user.username}
                </button>
                <div class="dropdown-menu mt-0" aria-labelledby="dropdownMenuButton">
                  <a class="dropdown-item" href="<%=basePaths%>/profile">个人信息</a>
                  <a class="dropdown-item" href="<%=basePaths%>/logout">退出登陆</a>
                </div>
              </div>
            </c:otherwise>
          </c:choose>
       </div>
     </div>
     <div class="subnav-middle"></div>
  </body>
</html>