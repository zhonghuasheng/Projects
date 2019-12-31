$(document).ready(function() {
    var mySwiper = new Swiper('.swiper-container',{
        effect : 'coverflow',
        slidesPerView: 3,
        centeredSlides: true,
        loop: true,
        coverflowEffect: {
          rotate: 30,
          stretch: 10,
          depth: 60,
          modifier: 2,
          slideShadows : true
        },
        autoplay: {
          delay: 2000
        },
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        }
      })
});
