<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
  </head>
  <body>
    <form action="<%=request.getContextPath()%>/user/login" method="post">
      <span>Username: </span>
      <input type="text" name="username">
      <br>
      <span>Password: </span>
      <input type="password" name="password">
      <br>
      <input type="submit" value="LOGIN">
    </form>
  </body>
</html>