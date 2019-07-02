<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="row ml-0 mr-0">
          <div class="float-left col-sm-3">
            <h4>艺术家</h4>
          </div>
          <div class="col-sm-8">
            <div class="float-right">
              <div class="app-search">
                <input class="app-search_input" type="search" placeholder="搜索">
                <button class="app-search_button">
                  <i class="fa fa-search"></i>
                </button>
              </div>
            </div>
          </div>
          <div class="action col-sm-1">
            <div class="float-right">
              <a class="btn btn-sm btn-success" href="<%=basePath%>admin/artist/create">创建</a>
            </div>
          </div>
        </div>

        <div class="row ml-0 mr-0">
           <div class="col-lg-12">
             <div class="line-head"></div>
           </div>
        </div>

        <div class="row ml-0 mr-0">
          <div class="col-lg-12">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>姓名</th>
                  <th>出生地</th>
                  <th>籍贯</th>
                  <th>UUID</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${artists}" var="artist">
                    <tr>
                      <td>${artist.name}</td>
                      <td>${artist.birthday}</td>
                      <td>${artist.region}</td>
                      <td>${artist.uuid}</td>
                      <td>
                        <button>Edit</button>
                        <button>Delete</button>
                      </td>
                    </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>

        </div>
      </div>
      <%@include file="/html/admin/footer.jsp" %>
    </div>
  </body>
</html>