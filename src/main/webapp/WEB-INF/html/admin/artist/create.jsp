<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePathInCreate = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Artist</title>
    <link rel="shortcut icon" href="<%=basePathInCreate%>/static/image/favicon.ico">
  </head>
  <body>
    <%@ include file="/WEB-INF/html/admin/header.jsp" %>
    <div class="content float-left">
      <div class="panel">
        <form id="artist-create" action="${pageContext.request.contextPath }/admin/artist/create" method="post" class="w-50 m-auto" enctype="multipart/form-data">
          <div class="form-group row">
            <div class="col-md-2 ">
              <label>照片</label>
            </div>
            <div class="col-md-8">
              <input id="avatar" type="file" name="avatar" class="form-control avatar" placeholder="照片"/>
              <span class="text-danger"><%=request.getAttribute("msg-avatar") ==  null ? "" : request.getAttribute("msg-avatar")%></span>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>姓名</label>
            </div>
            <div class="col-md-8">
              <input id="name" type="text" name="name" class="form-control" placeholder="姓名" value="${artist.name}"/>
              <span class="text-danger"><%=request.getAttribute("msg-name") == null ? "" : request.getAttribute("msg-name")%></span>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>出生年月</label>
            </div>
            <div class="col-md-8">
              <input id="birthday" type="date" name="birthday" class="form-control" placeholder="出生日期"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>籍贯</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="region" class="form-control" placeholder="省市">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>个人经历</label>
            </div>
            <div class="col-md-8">
              <textarea name="experience" rows="4" class="form-control" placeholder="个人经历"></textarea>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
            </div>
            <div class="col-md-5 pr-0 pl-0">
              <button type="submit" class="btn btn-primary">
                <i class="fa fa-fw fa-lg fa-check-circle"></i>
                  保存</button>
              <a class="btn btn-secondary" href="<%=basePathInCreate%>/admin/artist/list">
                <i class="fa fa-fw fa-lg fa-times-circle"></i>
                   取消</a>
            </div>
          </div>
        </form>
      </div>
      <%@include file="/WEB-INF/html/admin/footer.jsp" %>
    </div>
  </body>
  <script>
      $(document).ready(function() {
          $('.menu li').find('.menu-item-active').removeClass('menu-item-active');
          $('.menu li').find('.menu-artist').addClass('menu-item-active');
      });
  </script>
  <script type="text/javascript" src="<%=basePathInCreate%>/static/js/jquery-1.19.1.validate.min.js"></script>
  <script type="text/javascript" src="<%=basePathInCreate%>/static/js/artist/create.js"></script>
</html>