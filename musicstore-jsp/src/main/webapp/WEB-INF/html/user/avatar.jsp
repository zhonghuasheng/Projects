<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePath = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>修改个人头像</title>
    <link rel="shortcut icon" href="<%=basePath%>/static/image/favicon.ico">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/home.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/cropper/css/cropper.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap/css/bootstrap.min.css" />
    <style>
        .row{
            margin-bottom: 5px;
        }
        #photo {
            max-width: 100%;
        }
        .img-preview {
            width: 180px;
            height: 180px;
            overflow: hidden;
        }
    </style>
  </head>
  <body>
    <div class="body">
      <%@include file="/WEB-INF/html/common/header.jsp" %>
      <div class="container">
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath }/profile">个人信息</a></li>
            <li class="breadcrumb-item active" aria-current="page">修改个人头像</li>
          </ol>
        </nav>

        <div class="row">
          <div class="col-sm-12">
            <label for="input" class="btn btn-danger" id="">
              <span>上传头像</span>
              <input type="file" id="input" class="sr-only">
            </label>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-4">
            <img src="<%=basePath%>/static/image/default_cover.png" id="photo" style="width: 322px; height: 322px;">
          </div>
          <div class="col-sm-1"></div>
          <div class="col-sm-2">
            <div>
              <p>头像预览(180*180)：</p>
              <div class="img-preview"></div>
            </div>
          </div>
        </div>
        <br />
        <div class="row">
          <div class="col-sm-2">
            <button class="btn btn-primary">保存</button>
            <button class="btn btn-primary">取消</button>
          </div>
        </div>
      </div>

      <!-- Scripts -->
      <script src="<%=basePath%>/static/js/jquery-3.4.1.min.js"></script>
      <script src="<%=basePath%>/static/cropper/js/cropper.min.js"></script>
      <script src="<%=basePath%>/static/bootstrap/js/bootstrap.min.js"></script>
      <script>
          // 修改自官方demo的js
          var initCropper = function (img, input){
              var $image = img;
              var options = {
                  aspectRatio: 1, // 纵横比
                  viewMode: 2,
                  preview: '.img-preview' // 预览图的class名
              };
              $image.cropper(options);
              var $inputImage = input;
              var uploadedImageURL;
              if (URL) {
                  // 给input添加监听
                  $inputImage.change(function () {
                      var files = this.files;
                      var file;
                      if (!$image.data('cropper')) {
                          return;
                      }
                      if (files && files.length) {
                          file = files[0];
                          // 判断是否是图像文件
                          if (/^image\/\w+$/.test(file.type)) {
                              // 如果URL已存在就先释放
                              if (uploadedImageURL) {
                                  URL.revokeObjectURL(uploadedImageURL);
                              }
                              uploadedImageURL = URL.createObjectURL(file);
                              // 销毁cropper后更改src属性再重新创建cropper
                              $image.cropper('destroy').attr('src', uploadedImageURL).cropper(options);
                              $inputImage.val('');
                          } else {
                            window.alert('请选择一个图像文件！');
                        }
                    }
                });
              } else {
                  $inputImage.prop('disabled', true).addClass('disabled');
              }
          }
          var crop = function(){
              var $image = $('#photo');
              var $target = $('#result');
              $image.cropper('getCroppedCanvas',{
                  width:200, // 裁剪后的长宽
                  height:200
              }).toBlob(function(blob){
                  // 裁剪后将图片放到指定标签
                  $target.attr('src', URL.createObjectURL(blob));
              });
          }
          $(function(){
              initCropper($('#photo'),$('#input'));
          });
      </script>
      <%@include file="/WEB-INF/html/common/footer.jsp" %>
    </div>
  </body>
</html>