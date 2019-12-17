<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
String baseP = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Artist</title>
    <link rel="shortcut icon" href="<%=baseP%>/static/image/favicon.ico">
  </head>
  <body>
    <%@ include file="/WEB-INF/html/admin/header.jsp" %>
    <div class="content float-left">
      <div class="panel">
        <div class="row ml-0 mr-0">
          <div class="float-left col-sm-3">
            <h4>艺术家</h4>
          </div>
          <div class="col-sm-8">
            <div class="float-right">
              <div class="app-search">
                <div id="search" class="input-group mb-3 cursor-pointer">
                  <input type="text" class="form-control" placeholder="搜索" id="key" name="key">
                  <div class="input-group-append">
                    <span class="input-group-text">
                      <i class="fa fa-search"></i>
                    </span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="action col-sm-1">
            <div class="float-right">
              <a class="btn btn-success" href="<%=basePath%>/admin/artist/create">创建</a>
            </div>
          </div>
        </div>

        <div class="row ml-0 mr-0">
           <div class="col-lg-12">
             <div class="line-head"></div>
           </div>
        </div>

        <div class="row ml-0 mr-0">
          <div id="page-content" class="col-lg-12">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>姓名</th>
                  <th>出生日期</th>
                  <th>籍贯地</th>
                  <th>是否被删除</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              </tbody>
            </table>
          </div>
          <div id="page-footer" class="col-lg-12">
            <div class="float-left">
              <select id="pageSize" class="form-control">
                <option>5</option>
                <option>10</option>
                <option>20</option>
              </select>
            </div>
            <ul class="pagination float-right"></ul>
          </div>
        </div>

      <!-- Modal -->
      <div class="modal fade" id="deleteModal" role="dialog">
        <div class="modal-dialog">
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title">删除</h4>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
              <p>是否要删除这条记录？</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary btn-sm btn-yes" data-uuid="" data-dismiss="modal" onclick="deleteArtist()">是</button>
              <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">否</button>
            </div>
          </div>
        </div>
      </div>
      </div>
      <%@include file="/WEB-INF/html/admin/footer.jsp"%>
      <script src="<%=basePath%>/static/bootstrap/js/bootstrap.min.js"></script>
      <script src="<%=basePath%>/static/js/admin/admin-management.js"></script>
      <script src="<%=basePath%>/static/js/artist/list.js"></script>
    </div>
  </body>
  <script>
      $(document).ready(function() {
          $('.menu li').find('.menu-item-active').removeClass('menu-item-active');
          $('.menu li').find('.menu-artist').addClass('menu-item-active');
      });
  </script>
</html>