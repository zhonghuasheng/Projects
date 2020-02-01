<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
String basePath = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <link rel="shortcut icon" href="<%=basePath%>/static/image/favicon.ico">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/home.css" />
    <script src="<%=basePath%>/static/js/jquery-3.4.1.min.js"></script>
    <script>
      $(document).ready(function(){
          var gender="${user.gender }";
          if(gender=="MALE"){
              $("input[name='gender'][value='MALE']").attr("checked",true);
          }else if(gender=="FEMALE"){
              $("input[name='gender'][value='FEMALE']").attr("checked",true);
          }else{
              $("input[name='gender'][value='UNKNOW']").attr("checked",true);
          }
      });
    </script>
  </head>
  <body>
    <div class="body">
      <%@include file="/WEB-INF/html/common/header.jsp" %>
      <div class="container">
        <div class="row">
          <div class="col"></div>
          <div class="col-6">
            <div class="form-group">
              <br />
              <h3><span>个人信息</span></h3>
              <br />
            </div>
            <form id="profile-update" action="${pageContext.request.contextPath }/profile" method="post">
              <input type="hidden" id="uuid" name="uuid" value="${user.uuid }">
              <div class="form-group row">
                <c:choose>
                  <c:when test="${user.avatar==null }">
                    <img src="<%=basePath%>/static/image/avatar.png" id="avatar" style="width: 100px; height:100px;">
                    <a href="${pageContext.request.contextPath }/avatar" id="upload">上传头像</a>
                  </c:when>
                  <c:otherwise>
                    <img src="${user.avatar }" id="avatar" class="img-thumbnail" style="width: 100px; height:100px;">
                    <a href="${pageContext.request.contextPath }/avatar" id="update">更换头像</a>
                  </c:otherwise>
                </c:choose>
              </div>
              <div class="form-group row">
                <label for="username" class="col-sm-2 col-form-label">用户名</label>
                <div class="col-sm-10">
                  <input class="form-control" type="text" id="username" name="username" value="${user.username }">
                </div>
              </div>
              <div class="form-group row">
                <label for="email" class="col-sm-2 col-form-label">邮箱</label>
                <div class="col-sm-10">
                  <input readonly class="form-control-plaintext" type="text" id="email" name="email" value="${user.email }">
                </div>
              </div>
              <div class="form-group row">
                <label for="gender" class="col-sm-2 col-form-label">性别</label>
                <div class="col-sm-10">
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="MALE">
                    <label class="form-check-label" for="inlineRadio1">男</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="FEMALE">
                    <label class="form-check-label" for="inlineRadio2">女</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="inlineRadio3" value="UNKNOW">
                    <label class="form-check-label" for="inlineRadio3">保密</label>
                  </div>
                </div>
              </div>
              <div class="form-group row">
                <label for="birthday" class="col-sm-2 col-form-label">生日</label>
                <div class="col-sm-10">
                  <input type="date" id="birthday" name="birthday" class="form-control" placeholder="出生日期" value="${user.birthday }" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"/>
                </div>
              </div>
              <button type="submit" class="btn btn-primary w-100">保存</button>
            </form>
          </div>
          <div class="col"></div>
        </div>
      </div>
    <%@include file="/WEB-INF/html/common/footer.jsp" %>
    </div>
  </body>
</html>