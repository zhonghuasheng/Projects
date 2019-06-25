<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Admin Portal</title>

  </head>
    <body>
      <div class="pg-header">
          <div class="logo left">
            MusicStore
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

      <div class="menu f-left">
        <ul>
          <li>
            <a class="menu-item menu-item-active" href="#1">
              <i class="fa fa-dashboard"></i>
              <span>Dashboard</span>
            </a>
          </li>
          <li>
            <a class="menu-item" href="#2">
              <i class="fa fa-glide-g"></i>
              <span>Artist</span>
            </a>
          </li>
          <li>
            <a class="menu-item" href="#2">
              <i class="fa fa-music"></i>
              <span>Music</span>
            </a>
          </li>
          <li>
            <a class="menu-item" href="#2">
              <i class="fa fa-users"></i>
              <span>Users</span>
            </a>
          </li>
          <li>
            <a class="menu-item" href="#2">
              <i class="fa fa-tasks"></i>
              <span>Orders</span>
            </a>
          </li>
          <li>
            <a class="menu-item" href="#2">
              <i class="fa fa-commenting"></i>
              <span>Message</span>
            </a>
          </li>
        </ul>
      </div>
  </body>
</html>