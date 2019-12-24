<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePathInCreate = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Music</title>
    <link rel="shortcut icon" href="<%=basePathInCreate%>/static/image/favicon.ico">
  </head>
  <body>
    <%@ include file="/WEB-INF/html/admin/header.jsp" %>
    <div class="content float-left">
      <div class="panel">
        <form id="music-create" action="${pageContext.request.contextPath }/admin/music/create" method="post" class="w-50 m-auto" enctype="multipart/form-data">
          <div class="form-group row">
            <div class="col-md-2 ">
              <label>音乐名</label>
            </div>
            <div class="col-md-8">
              <input id="title" type="text" name="title" class="form-control" placeholder="音乐名" value="${music.title}"/>
              <span class="text-danger"><%=request.getAttribute("msg-title") == null ? "" : request.getAttribute("msg-title")%></span>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>艺人</label>
            </div>
            <div class="col-md-8">
              <select name="artistUuid" class="form-control">
                <c:forEach var="artist" items="${artists}">
                  <option value="${artist.uuid}">${artist.name}</option>
                </c:forEach>
              </select>
              <span class="text-danger"><%=request.getAttribute("msg-artist") == null ? "" : request.getAttribute("msg-artist")%></span>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>发布时间</label>
            </div>
            <div class="col-md-8">
              <input id="publish-date" type="date" name="publishDate" class="form-control" placeholder="发布时间"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2">
              <label>发布公司</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="publishCompany" class="form-control" placeholder="发布公司">
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
            </div>
            <div class="col-md-5 pr-0 pl-0">
              <button type="submit" class="btn btn-primary">
                <i class="fa fa-fw fa-lg fa-check-circle"></i>
                  保存</button>
              <a class="btn btn-secondary" href="<%=basePathInCreate%>/admin/music/list">
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
          $('.menu li').find('.menu-music').addClass('menu-item-active');
      });
  </script>
  <script type="text/javascript" src="<%=basePathInCreate%>/static/js/jquery-1.19.1.validate.min.js"></script>
  <script type="text/javascript" src="<%=basePathInCreate%>/static/js/music/create.js"></script>
</html>