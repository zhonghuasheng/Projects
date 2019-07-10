<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Artist</title>
    <link rel="shortcut icon" href="../static/image/favicon.ico">
  </head>
  <body>
    <%@ include file="/html/admin/header.jsp" %>
    <div class="content float-left">
      <div class="panel">
        <form action="${pageContext.request.contextPath }/admin/artist/edit" method="post" class="w-50 m-auto" enctype="multipart/form-data">
          <div class="form-group row">
            <div class="col-md-3 mt-auto">
              <input type="text" name="uuid" class="d-none" value="${artist.uuid}"/>
            </div>
            <div class="col-md-3">
              <img class="rounded-circle" alt="" src="${pageContext.request.contextPath }/document-upload/avatar/${artist.avatar}">
            </div>
            <div class="col-md-3">
              <input type="text" name="originalAvatar" class="d-none" value="${artist.avatar}"/>
            </div>
          </div>
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
              <input type="text" name="name" class="form-control" placeholder="姓名" value="${artist.name }"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">出生年月</label>
            </div>
            <div class="col-md-8">
              <input type="date" name="birthday" class="form-control" placeholder="出生日期" value="${artist.birthday }"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">籍贯</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="region" class="form-control" placeholder="省市"  value="${artist.region }">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">个人经历</label>
            </div>
            <div class="col-md-8">
              <textarea name="experience" rows="4" class="form-control" placeholder="个人经历">${artist.experience }</textarea>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
            </div>
            <div class="col-md-5 pr-0 pl-0">
              <button type="submit" class="btn btn-primary">
                <i class="fa fa-fw fa-lg fa-check-circle"></i>
                  更新</button>
              <a class="btn btn-secondary" href="<%=basePath%>admin/artist/list">
                <i class="fa fa-fw fa-lg fa-times-circle"></i>
                   取消</a>
            </div>
          </div>
        </form>
      </div>
      <%@include file="/html/admin/footer.jsp" %>
    </div>
  </body>
</html>