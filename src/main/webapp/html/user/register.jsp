<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>注册</title>
  <link rel="shortcut icon" href="../static/image/favicon.ico">
  <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap.css"/>
  <link rel="stylesheet" type="text/css" href="../static/css/register.css"/>
  </head>
  <body>
    <div class="row register">
      <div class="col-md-7"></div>
      <div class="col-md-5">
        <div class="col-md-1"></div>
        <div class="col-md-10 container">
          <div class="register-form w-75 mt-5 transucent-fillet pt-4 pb-4">
            <form action="${pageContext.request.contextPath }/user/register" method="post" class="w-75 m-auto">
              <div class="form-group">
                <label>用户名</label>
                <input type="text" name="username" class="form-control" placeholder="用户名" />
              </div>
              <div class="form-group">
                <label>邮箱</label>
                <input type="text" name="email" class="form-control" placeholder="邮箱"/>
              </div>
              <div class="form-group">
                <label>密码</label>
                <input type="password" name="password" class="form-control" placeholder="密码"/>
              </div>
              <div class="form-group">
                <label>确认密码</label>
                <input type="password" name="confirmPassword" class="form-control" placeholder="确认密码"/>
              </div>
              <div class="form-group">
                <label>出生日期</label>
                <input type="date" name="birthday" class="form-control" placeholder="出生日期"/>
              </div class="form-group">
              <button type="submit" class="btn btn-primary w-100">注册</button>
            </form>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
  </body>
</html>