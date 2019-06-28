<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Artist</title>
  </head>
  <body>
    <%@ include file="/html/admin/header.jsp" %>
    <div class="content float-left">
      <div class="panel">
        <form action="${pageContext.request.contextPath }/admin/artist/create" method="post" class="w-50 m-auto">
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">照片</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="avtar" class="form-control" placeholder="照片"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">姓名</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="name" class="form-control" placeholder="姓名"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">出生年月</label>
            </div>
            <div class="col-md-8">
              <input type="date" name="birthday" class="form-control" placeholder="出生日期"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">籍贯</label>
            </div>
            <div class="col-md-8">
              <input type="text" name="region" class="form-control" placeholder="省市">
            </div>
          </div>
          <div class="form-group row">
            <div class="col-md-2 mt-auto">
              <label class="control-label">个人经历</label>
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