<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+ "://" + request.getServerName()
    + ":" + request.getServerPort() + path + "/";
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <base href="<%=basePath%>">
  </head>
  <body>
    <%@ include file="/html/admin/header.jsp" %>
    <div class="content f-left">
      <div>

      </div>
    </div>
    <%@include file="/html/admin/footer.jsp" %>
  </body>
</html>