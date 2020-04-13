<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>音乐详情</title>
    <script src="${pageContext.request.contextPath}/static/js/music/view.js"></script>
  </head>
  <body>
    <%@include file="/WEB-INF/html/common/header.jsp"%>
    <div class="wd-6 m-auto pt-30">
      <div>
        <div class="row">
          <div class="col-3">
            <img src="${pageContext.request.contextPath}/document-upload/avatar/${artist.avatar}"/>
          </div>
          <div class="float-left col-7">
            <div class="row">
              <span style="color:black;font-size:26px;">${music.title}</span>
            </div>
            <div class="row"><span class="c-999">歌手:</span><span><a class="" href="${pageContext.request.contextPath }/artist?uuid=${artist.uuid}">${artist.name}</a></span></div>
            <p/>
            <div class="row">
              <div class="float-left">
                <button class="btn btn-outline-secondary btn-sm" onclick="addToCart('${music.uuid}')">加入购物车</button>
              </div>
              <div class="float-left ml-10">
                <button class="btn btn-outline-secondary btn-sm order">下单</button>
              </div>
              <div class="float-left ml-10">
                <button class="btn btn-outline-secondary btn-sm recommendStar">推荐</button>
              </div>
            </div>
            <p/>
            <div class="row">
              作曲 : 光头华夏<br>作词 : 光头华夏<br>夜半风雨声<br>惊醒梦中人<br>谁在立秋之后<br>时常来叩门<br>若终其一生<br>仍为情所困<br>宁愿开始<br>就只一个人<br>清晨一盏灯<br>照亮了前尘<br>谁在大雪之前<br>
            </div>
          </div>
        </div>
        <div class="pt-30">
          <p>评论区: 待开发</p>
        </div>
      </div>
    </div>
  </body>
</html>