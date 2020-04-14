<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePath = request.getContextPath();
%>
<html>
  <head>
  <meta charset="UTF-8">
  <title>注册</title>
  <link rel="shortcut icon" href="<%=basePath%>/static/image/favicon.ico">
  <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap/css/bootstrap.css"/>
  <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/register.css"/>
  </head>
  <body>
    <div class="row register">
      <div class="col-md-7"></div>
      <div class="col-md-5">
        <div class="col-md-1"></div>
        <div class="col-md-10 container">
          <div class="register-form w-75 mt-5 transucent-fillet pt-4 pb-4">
            <form id="register" action="${pageContext.request.contextPath }/register" method="post" class="w-75 m-auto">
              <div class="form-group">
                <label for="username">用户名（必填）</label>
                <input id="username" type="text" name="username" class="form-control" placeholder="用户名" value="${user.username}" required/>
                <span class="text-danger"><%=request.getAttribute("msg-username") == null ? "" : request.getAttribute("msg-username") %></span>
              </div>
              <div class="form-group">
                <label for="email">邮箱（必填）</label>
                <input id="email" type="email" name="email" class="form-control" placeholder="邮箱" value="${user.email}" required/>
                <span class="text-danger"><%=request.getAttribute("msg-email") == null ? "" : request.getAttribute("msg-email") %></span>
              </div>
              <div class="form-group">
                <label for="password">密码（必填）</label>
                <input id="password" type="password" name="password" class="form-control" placeholder="密码" required/>
                <span class="text-danger"><%=request.getAttribute("msg-password") == null ? "" : request.getAttribute("msg-password") %></span>
              </div>
              <div class="form-group">
                <label for="confirmPassword">确认密码（必填）</label>
                <input id="confirmPassword" type="password" name="confirmPassword" class="form-control" placeholder="确认密码" required/>
                <span class="text-danger"><%=request.getAttribute("msg-confirmPassword") == null ? "" : request.getAttribute("msg-confirmPassword") %></span>
              </div>
              <div class="form-group">
                <label for="birthday">出生日期</label>
                <input id="birthday" type="date" name="birthday" class="form-control" placeholder="出生日期" value="${user.birthday }" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"/>
                <span class="text-danger"><%=request.getAttribute("msg-birthday") == null ? "" : request.getAttribute("msg-birthday") %></span>
              </div>
              <button type="submit" class="btn btn-primary w-100">注册</button>
            </form>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
    <script src="<%=basePath%>/static/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery-1.19.1.validate.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/user/register.js"></script>
  </body>
</html>