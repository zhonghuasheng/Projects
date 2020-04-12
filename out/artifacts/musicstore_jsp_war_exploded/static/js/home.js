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
      })
});
