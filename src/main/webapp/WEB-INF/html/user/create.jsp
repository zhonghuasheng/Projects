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
      <div id="user-create" class="panel">
        <form action="${pageContext.request.contextPath }/admin/user/create" method="post" class="w-50 m-auto" enctype="multipart/form-data">
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">照片</label>
            </div>
            <div class="col-md-8">
              <input type="file" name="avatar" class="form-control avatar" placeholder="照片"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">姓名</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="username" class="form-control" placeholder="姓名（必填）"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">邮箱</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="email" class="form-control" placeholder="邮箱（必填）"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">密码</label>
            </div>
            <div class="col-md-8">
              <input type="password" name="password" class="form-control" placeholder="密码（必填）">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">确认密码</label>
            </div>
            <div class="col-md-8">
              <input type="password" name="confirm-password" class="form-control" placeholder="确认密码（必填）">
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
            </div>
            <div class="col-md-5 pr-0 pl-0">
              <button type="submit" class="btn btn-primary">
                <i class="fa fa-fw fa-lg fa-check-circle"></i>
                  保存</button>
              <a class="btn btn-secondary" href="<%=basePathInCreate%>/admin/user/list">
                <i class="fa fa-fw fa-lg fa-times-circle"></i>
                   取消</a>
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
</html>