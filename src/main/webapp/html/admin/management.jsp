<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Admin Portal</title>
    <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="../static/admin-portal.css">
  </head>
    <body>
    <div class="pg-header">
        <div class="logo left">
              音乐商店
        </div>

        <div class="user right">
            <a class="a fa fa-user fa-fw" href="#">

            </a>
            <!--鼠标放在头像上的下拉框-->
            <div class="b">
                <a href="#">我的资料</a>
                <a href="#">注销</a>
            </div>
        </div>

        <div class="icons right">
            <i class="fa fa-commenting-o" aria-hidden="true"></i>
            <!--从图标官网找图标引用语句复制下来 -->
            <span class="info">5 </span>  <!--比如5条消息-->
        </div>
        <div class="icons right">
            <i class="fa fa-bell-o" aria-hidden="true"></i>
        </div>
    </div>
    <div class="pg-content">
        <div class="menu left">
            <div style="background-color: green">a</div>
            <div style="background-color: burlywood">b</div>
            <div style="background-color: cadetblue">c</div>
        </div>
        <div class="content left">
            <div style="background-color: purple">
                内容在这里
            </div>
        </div>
    </div>
    <div class="pg-footer"></div>
  </body>
</html>