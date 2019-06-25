/*
 * menu part
 */

/*add click event on menu item li*/
$('.pg-content .menu li').on('click', function() {
    $('.pg-content .menu li').find('.menu-item-active').removeClass('menu-item-active');
    $(this).find('a').addClass('menu-item-active');
});