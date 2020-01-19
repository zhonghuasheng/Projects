<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePath = request.getContextPath();
%>
<html>
  <head>
  <meta charset="UTF-8">
  <title>登陆</title>
  <link rel="shortcut icon" href="<%=basePath%>/static/image/favicon.ico">
  <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap/css/bootstrap.css"/>
  <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/login.css"/>
  </head>
  <body>
    <div class="row login">
      <div class="col-md-7"></div>
      <div class="col-md-5">
        <div class="col-md-1"></div>
        <div class="col-md-10 container">
          <div class="register-form w-75 transucent-fillet pt-4 pb-4">
            <form id="login" action="${pageContext.request.contextPath }/login" method="post" class="w-75 m-auto">
              <div class="form-group">
                <label for="email">账号</label>
                <input id="email" type="text" name="email" class="form-control" placeholder="账号" value="${user.email}"/>
                <span class="text-danger"><%=request.getAttribute("msg-email") == null ? "" : request.getAttribute("msg-email") %></span>
              </div>
              <div class="form-group">
                <label for="password">密码</label>
                <input id="password" type="password" name="password" class="form-control" placeholder="密码" value="${user.password}"/>
                <span class="text-danger"><%=request.getAttribute("msg-password") == null ? "" : request.getAttribute("msg-password") %></span>
              </div>
              <span class="text-danger"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error") %></span>
              <button type="submit" class="btn btn-primary w-100">登陆</button>
            </form>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
    <script src="<%=basePath%>/static/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery-1.19.1.validate.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/user/login.js"></script>
  </body>
</html>