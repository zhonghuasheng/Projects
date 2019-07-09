$(document).ready(function(){
    /*
     * menu part
     */

    /*adds click event on menu item li*/
    $('.pg-content .menu li').on('click', function() {
        $('.pg-content .menu li').find('.menu-item-active').removeClass('menu-item-active');
        $(this).find('a').addClass('menu-item-active');
    });

    /* searches artists by keywords */
    $('.app-search_button').on('click', function() {
        $.ajax({
            url: '/musicstore-jsp/admin/artist/',
            data: {
                'currentPage': 1,
                'pageSize': 1,
                'key': ''
            },
            type: 'post',
            cache: false,
            dataType: 'json',
            success: function(data) {
                console.log(data);
            }
        });
    })
});

var deleteArtist = function(uuid) {
    $('#deleteArtistModal').modal();
}