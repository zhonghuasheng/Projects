<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePath = request.getContextPath();
%>
<html>
  <head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="shortcut icon" href="<%=basePath%>/static/image/favicon.ico">
  <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap/css/bootstrap.css"/>
  <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/login.css"/>
  </head>
  <body>
    <div class="row register">
      <div class="col-md-7"></div>
      <div class="col-md-5">
        <div class="col-md-1"></div>
        <div class="col-md-10 container">
          <div></div>
          <div class="register-form w-75 transucent-fillet pt-4 pb-4">
            <form action="${pageContext.request.contextPath }/login" method="post" class="w-75 m-auto">
              <div class="form-group">
                <label>账号</label>
                <input type="text" name="email" class="form-control" placeholder="账号"/>
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