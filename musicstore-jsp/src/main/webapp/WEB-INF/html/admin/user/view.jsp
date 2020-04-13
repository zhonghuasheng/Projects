<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String basePathInEdit = request.getContextPath();
%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User</title>
    <link rel="shortcut icon" href="<%=basePathInEdit%>/static/image/favicon.ico">
  </head>
  <body>
    <%@ include file="/WEB-INF/html/admin/header.jsp" %>
    <div class="content float-left">
      <div id="user-create" class="panel">
        <form action="${pageContext.request.contextPath }/admin/user/edit" method="post" class="w-50 m-auto" enctype="multipart/form-data">
          <div class="form-group row">
            <div class="col-md-3 mt-auto">
              <input type="text" name="uuid" class="d-none" value="${user.uuid}" />
            </div>
            <div class="col-md-3">
              <img class="rounded-circle avatar-size" alt="" src="${pageContext.request.contextPath}/document-upload/avatar/${user.avatar}">
            </div>
            <div class="col-md-3">
              <input type="text" name="originalAvatar" class="d-none" value="${user.avatar}"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">姓名</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="username" class="form-control" readonly value="${user.username}"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">邮箱</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="email" class="form-control" readonly value="${user.email}"/>
            </div>
          </div>
        </form>
      </div>
      <%@include file="/WEB-INF/html/admin/footer.jsp" %>
      <script src="<%=basePath%>/static/js/user/create.js"></script>
    </div>
  </body>
  <script>
      $(document).ready(function() {
          $('.menu li').find('.menu-item-active').removeClass('menu-item-active');
          $('.menu li').find('.menu-user').addClass('menu-item-active');
      });
  </script>
  </body>
</html>