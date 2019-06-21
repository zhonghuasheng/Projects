<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>登陆</title>
  <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap.css"/>
  <link rel="stylesheet" type="text/css" href="../static/css/login.css"/>
  </head>
  <body>
    <div class="row register">
      <div class="col-md-7"></div>
      <div class="col-md-5">
        <div class="col-md-1"></div>
        <div class="col-md-10 container">
          <div></div>
          <div class="register-form w-75 transucent-fillet pt-4 pb-4">
            <form action="${pageContext.request.contextPath }/user/login" method="post" class="w-75 m-auto">
              <div class="form-group">
                <label>邮箱</label>
                <input type="text" name="email" class="form-control" placeholder="邮箱"/>
              </div>
              <div class="form-group">
                <label>密码</label>
                <input type="password" name="password" class="form-control" placeholder="密码"/>
              </div>
              <button type="submit" class="btn btn-primary w-100">登陆</button>
            </form>
          </div>
          <div></div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
  </body>
</html>