$(document).ready(function() {
    let mySwiper = new Swiper('.swiper-container',{
        effect : 'coverflow',
        slidesPerView: 3,
        centeredSlides: true,
        loop: true,
        coverflowEffect: {
          rotate: 30,
          stretch: 20,
          depth: 20,
          modifier: 3,
          slideShadows : true
        },
        autoplay: {
          delay: 2000
        },
        prevButton:'.swiper-button-prev',
        nextButton:'.swiper-button-next',
      });

    // 推荐音乐
    $.ajax({
        url: "/musicstore/music/recommendation",
        type: "get",
        async: true,
        dataType: "json",
        success: function(data) {
            console.log(data);
            const musics = data.data;
            if (musics.length != 0) {
                let html = "";
                musics.forEach(function(item) {
                    html += '<div class="recommend-item"><img src="'
                         + item.uuid
                         + '.png">'
                         + '<div class="recommend-item-title"><a href="/musicstore/music/view?uuid='
                         + item.uuid
                         + '">'
                         + item.title
                         + '</a></div></div>';

                });
                $(".recommend-hot .recommend-li").append(html);
            }
        },
        error: function() {
            $(".recommend-hot").hide();
        }
    });

    // 推荐艺人
    $.ajax({
        url: "/musicstore/artist/recommendation",
        type: "get",
        async: true,
        dataType: "json",
        success: function(data) {
            console.log(data);
            const artists = data.data;
            if (artists.length > 0) {
                let html = "";
                artists.forEach(function (item) {
                    html += '<div class="recommend-item"><img src="/musicstore/document-upload/avatar/'
                         + item.avatar
                         + '"><div class="recommend-item-title"><a href="/playlist?id=924680166">'
                         + item.name
                         + '</a></div></div>';
                });
                $(".recommend-artist .recommend-li").append(html);
            }
        },
        error: function() {
            $(".recommend-artist").hide();
        }
    });

    // 最新入驻
    $.ajax({
        url: "/musicstore/tester",
        type: "get",
        async: true,
        dataType: "json",
        success: function(data) {
            console.log(data);
            const users = data.data;
            if (users.length > 0) {
                let html = "";
                users.forEach(function(item) {
                    html += '<div class="vistor"><div class="avator"><img src="/musicstore/document-upload/avatar/'
                         + item.avatar
                         + '"></div><div class="vistor-info"><p>'
                         + item.username
                         + '</p></div></div>';
                });
                $('.new-user-li').append(html);
            }
        },
        error: function() {
            $('.new-user-li').hide();
        }
    });
});



