$(document).ready(function() {
    var mySwiper = new Swiper('.swiper-container',{
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
        url: "/musicstore/recommendation",
        type: "get",
        async: true,
        dataType: "json",
        success: function(data) {
            console.log(data);
            var musics = data.data;
            if (musics.length != 0) {
                var html = "";
                musics.forEach(function(item) {
                    html += '<div class="recommend-item"><img src="'
                         + item.uuid
                         + '.png">'
                         + '<div class="recommend-item-title"><a href="/playlist?id=924680166">'
                         + item.title
                         + '</a></div></div>';

                });
                $(".recommend-hot").append(html);
            }
        },
        error: function() {
            $(".recommend-hot").hide();
        }
    });
});
