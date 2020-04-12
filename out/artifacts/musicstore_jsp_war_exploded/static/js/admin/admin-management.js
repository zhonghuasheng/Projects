$(document).ready(function(){
    /*
     * menu part
     */

    /*adds click event on menu item li*/
    $('.menu li').on('click', function() {
        $('.menu li').find('.menu-item-active').removeClass('menu-item-active');
        $(this).find('a').addClass('menu-item-active');
    });
});

var showDeleteModal = function(uuid) {
    $('#deleteModal').modal();
    $('#deleteModal .btn-yes').data('uuid', uuid);
}

var deleteUser = function() {
    var uuid = $('#deleteModal .btn-yes').data('uuid');
    $.ajax({
         url: '/musicstore/admin/user/delete',
         data: {
             'uuid': uuid
         },
         type: 'post',
         cache: false,
         dataType: 'text',
         success: function(data) {
            console.log(data);
             window.location.reload();
         },
         error: function() {
             alert('删除失败，请重试');
         }
    });
}