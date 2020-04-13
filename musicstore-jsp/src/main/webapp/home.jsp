<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String basePath = request.getContextPath();
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="shortcut icon" href="<%=basePath%>/static/image/favicon.ico">
    <link rel="stylesheet" href="<%=basePath%>/static/swiper/swiper.css">
  </head>
  <body>
    <div class="body">
      <%@include file="/WEB-INF/html/common/header.jsp" %>
      <div class="content">
        <div class="swiper-container">
          <div id="sw" class="swiper-wrapper">
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_fjords_wide.jpg"></div>
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_nature_wide.jpg"></div>
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_mountains_wide.jpg"></div>
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_fjords_wide.jpg"></div>
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_nature_wide.jpg"></div>
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_mountains_wide.jpg"></div>
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_fjords_wide.jpg"></div>
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_nature_wide.jpg"></div>
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_mountains_wide.jpg"></div>
            <div class="swiper-slide"><img src="http://static.runoob.com/images/mix/img_nature_wide.jpg"></div>
          </div>
          <!-- Add Pagination -->
          <div class="swiper-pagination"></div>
          <!-- Add Arrows -->
          <div class="swiper-button-next"></div>
          <div class="swiper-button-prev"></div>
        </div>
      </div>

      <div class="recommend">
        <div class="recommend-left">
          <div>最新入驻</div>
          <div class="subnav-small"></div>
          <div class="vistor">
            <div class="avator">
              <img src="https://p1.music.126.net/trwwNtVci3Udu5ilCZvCjA==/109951163170492501.jpg?param=62y62">
            </div>
            <div class="vistor-info">
              <p>测试1</p>
              <p>最新添加歌曲</p>
            </div>
          </div>
          <div class="vistor">
              <div class="avator">
                <img src="https://p2.music.126.net/sxyGTra05rFof5i9w3PXzQ==/109951163710520009.jpg?param=62y62">
              </div>
              <div class="vistor-info">
                <p>测试2</p>
                <p>最新添加歌曲</p>
              </div>
            </div>
            <div class="vistor">
              <div class="avator">
                <img class="j-img" src="http://p2.music.126.net/6wPGl_ddgAbJTx5kOohcyw==/109951163892302996.jpg?param=62y62">
              </div>
              <div class="vistor-info">
                <p>测试3</p>
                <p>最新添加歌曲</p>
              </div>
            </div>
            <div class="vistor">
              <div class="avator">
                <img src="https://p2.music.126.net/s8OI0XtIyZYrijkQA8WjhQ==/109951164432772995.jpg?param=62y62">
              </div>
              <div class="vistor-info">
                <p>测试4</p>
                <p>最新添加歌曲</p>
              </div>
            </div>
            <div class="apply">
              <a type="button" class="btn btn-outline-secondary wd-8" href="<%=basePath%>/register">加入测试</a>
            </div>
        </div>
        <div class="recommend-right">
          <div class="recommend-hot">
              <div class="title">热门推荐</div>
              <div class="subnav-small"></div>
              <div class="recommend-li"></div>
          </div>
          <div class="recommend-artist">
            <div class="title">艺人推荐</div>
            <div class="subnav-small"></div>
            <div class="recommend-li">
              <div class="recommend-item">
                <img src="http://p1.music.126.net/7BUW9dnqOMF1dn3ioKJOMg==/109951162820707114.jpg?param=130y130">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">Fine乐团</a>
                </div>
              </div>
              <div class="recommend-item">
                <img src="https://p2.music.126.net/hLyY_DS9HEyVP8g-tILrhw==/109951164403538344.jpg?param=130y130">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">吧唧</a>
                </div>
              </div>
              <div class="recommend-item">
                <img src="https://p2.music.126.net/iAovAM_8kMGipBanezFrxQ==/109951164375666874.jpg?param=130y130">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">God Group</a>
                </div>
              </div>
              <div class="recommend-item">
                <img src="https://p1.music.126.net/EiKm0Rn1fTropuu95Ymtag==/109951163116060501.jpg?param=130y130">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">Coky Fly</a>
                </div>
              </div>
              <div class="recommend-item">
                <img src="https://p2.music.126.net/BkWzl679wgBVxQMl4_7YFg==/109951164394770025.jpg?param=130y130">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">千里狗</a>
                </div>
              </div>
            </div>
          </div>
          <div class="recommend-music">
            <div class="title">猜你喜欢</div>
            <div class="subnav-small"></div>
            <div class="recommend-li">
              <div class="recommend-item">
                <img src="http://p2.music.126.net/GqJF6zWGILyvCZhRMJjybQ==/109951164571859436.jpg?param=140y140">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">请注意，开往2020的列车即将到站</a>
                </div>
              </div>
              <div class="recommend-item">
                <img src="http://p2.music.126.net/_ldY-Tf5dCIubyyeATSrdA==/109951164322846413.jpg?param=140y140">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">你搜不到的土嗨神曲</a>
                </div>
              </div>
              <div class="recommend-item">
                <img src="http://p2.music.126.net/53PMdAT4YnFBwHNe4jcA2A==/109951164413921658.jpg?param=140y140">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">【说唱】The Prattle</a>
                </div>
              </div>
              <div class="recommend-item">
                <img src="http://p2.music.126.net/ptk6iL-vV0oqo-j9XPlcNg==/109951164493217877.jpg?param=140y140">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">世 界 最 强 Flow 最 炸 说 唱 集 合 体</a>
                </div>
              </div>
              <div class="recommend-item">
                <img src="http://p2.music.126.net/Fs0DjAvcAAyAZa1dgXzFfQ==/109951163571833739.jpg?param=140y140">
                <div class="recommend-item-title">
                  <a href="/playlist?id=924680166">听说你也在找好听的华语歌</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <%@include file="/WEB-INF/html/common/footer.jsp" %>
    </div>
    <script src="<%=basePath%>/static/swiper/swiper.js"> </script>
    <script src="<%=basePath%>/static/js/home.js"> </script>
  </body>
</html>