<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
  String basePath = request.getContextPath();
%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>音乐人</title>
    <link rel="stylesheet" href="<%=basePath%>/static/fontawesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap/css/bootstrap.css" />
  </head>
  <body>
    <div class="content" style="width: 60%; margin: auto">
      <div class="panel">
        <div class="form-group row">
          <div class="col-md-3 mt-auto">
            <input type="text" name="uuid" class="d-none" value="${artist.uuid}"/>
          </div>
          <div class="col-md-3">
            <img class="rounded-circle avatar-size" alt="" src="${pageContext.request.contextPath }/document-upload/avatar/${artist.avatar}">
          </div>
          <div class="col-md-3">
            <input type="text" name="originalAvatar" class="d-none" value="${artist.avatar}"/>
          </div>
        </div>
        <div class="form-group row">
          <div class="col-md-2 mt-auto">
            <label class="control-label">姓名</label>
          </div>
          <div class="col-md-8">
            <input type="text" name="name" readonly="true" class="form-control" placeholder="姓名" value="${artist.name }"/>
          </div>
        </div>
        <div class="form-group row">
          <div class="col-md-2 mt-auto">
            <label class="control-label">出生年月</label>
          </div>
          <div class="col-md-8">
            <input type="date" name="birthday" readonly="true" class="form-control" placeholder="出生日期" value="${artist.birthday }"/>
          </div>
        </div>
        <div class="form-group row">
          <div class="col-md-2 mt-auto">
            <label class="control-label">籍贯</label>
          </div>
          <div class="col-md-8">
            <input type="text" name="region" readonly="true" class="form-control" placeholder="省市"  value="${artist.region }">
          </div>
        </div>
        <div class="form-group row">
          <div class="col-md-2 mt-auto">
            <label class="control-label">个人经历</label>
          </div>
          <div class="col-md-8">
            <textarea name="experience" rows="4" readonly="true" class="form-control" placeholder="个人经历">${artist.experience }</textarea>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>