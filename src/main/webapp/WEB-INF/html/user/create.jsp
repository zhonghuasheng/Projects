<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePathInCreate = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>User</title>
    <link rel="shortcut icon" href="<%=basePathInCreate%>/static/image/favicon.ico">
  </head>
  <body>
    <%@ include file="/WEB-INF/html/admin/header.jsp" %>
    <div class="content float-left">
      <div class="panel">
        <form id="user-create" action="${pageContext.request.contextPath }/admin/user/create" method="post" class="w-50 m-auto" enctype="multipart/form-data">
          <div class="form-group row">
            <div class="col-md-2">
              <span>照片</span>
            </div>
            <div class="col-md-8">
              <input type="file" name="avatar" class="form-control avatar" placeholder="照片"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>用户名</label>
            </div>
            <div class="col-md-8">
              <input id="username" type="text" name="username" class="form-control" placeholder="用户名" value="${user.username}"/>
              <span class="text-danger"><%=request.getAttribute("msg-username") == null ? "" : request.getAttribute("msg-username") %></span>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <span class="control-label">邮件</span>
            </div>
            <div class="col-md-8">
              <input id="email" type="text" name="email" class="form-control" placeholder="邮件" value="${user.email}"/>
              <span class="text-danger"><%=request.getAttribute("msg-email") == null ? "" : request.getAttribute("msg-email") %></span>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>出生日期</label>
            </div>
            <div class="col-md-8">
              <input type="date" name="birthday" class="form-control" placeholder="出生日期" value="${user.birthday}"/>
              <span class="text-danger"><%=request.getAttribute("msg-birthday") == null ? "" : request.getAttribute("msg-birthday")%></span>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>密码</label>
            </div>
            <div class="col-md-8">
              <input type="password" name="password" class="form-control" placeholder="密码">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>确认密码</label>
            </div>
            <div class="col-md-8">
              <input type="password" name="confirmPassword" class="form-control" placeholder="确认密码">
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
            </div>
            <div class="col-md-5 pr-0 pl-0">
              <button type="submit" class="btn btn-primary">
                <i class="fa fa-fw fa-lg fa-check-circle"></i>
                  提交</button>
              <a class="btn btn-secondary" href="<%=basePathInCreate%>/admin/user/list">
                <i class="fa fa-fw fa-lg fa-times-circle"></i>
                  取消</a>
            </div>
          </div>
        </form>
      </div>
      <%@include file="/WEB-INF/html/admin/footer.jsp" %>
      <script type="text/javascript" src="<%=basePath%>/static/js/jquery-1.19.1.validate.min.js"></script>
      <script src="<%=basePath%>/static/js/user/create.js"></script>
    </div>
  </body>
  <script>
      $(document).ready(function() {
          $('.menu li').find('.menu-item-active').removeClass('menu-item-active');
          $('.menu li').find('.menu-user').addClass('menu-item-active');
      });
  </script>
</html>