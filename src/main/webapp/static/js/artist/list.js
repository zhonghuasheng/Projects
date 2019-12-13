$(document).ready(function(){
    pagination();
});

function pagination() {
    $.ajax({
        type: 'post',
        async: true, // 异步请求。（同步请求会锁住浏览器，用户的其他操作必须等待请求完成才能执行）
        url: '/musicstore/admin/artist/list',
        data: {
            'currentPage': '',
            'pageSize': '',
            'key': '',
        },
        dataType: "json",
        success: function(result) {
            renderPageContent(result.data);
            renderPagination(result);
        },
        error: function() {

        }
    });
}

function renderPageContent(data) {
    var content;
    for (var row in data) {
        content += '<tr><td>' + data[row].name + '</td><td>' + data[row].birthday + '</td><td>' + data[row].region
        + '</td><td>' + data[row].deleted + '</td><td><a class="btn btn-sm btn-secondary" href="/musicstore/admin/artist/edit?uuid=' + data[row].uuid
        + '">修改</a><button type="button" class="btn btn-sm btn-danger" onclick="showDeleteModal('+ "'" +data[row].uuid + "'" +')">删除</button></td></tr>';
    }
    var pageContent = $('#page-content tbody');
    pageContent.empty();
    pageContent.append(content);
}

function renderPagination(result) {

}

$('.app-search_button').on('click', function() {
    pagination();
});

var deleteArtist = function() {
    var uuid = $('#deleteModal .btn-yes').data('uuid');
    $.ajax({
        url: '/musicstore/admin/artist/delete',
        data: {
            'uuid': uuid
        },
        type: 'post',
        cache: false,
        dataType: 'text',
        success: function(data) {
            window.location.reload();
        },
        error: function() {
            alert('删除失败，请重试');
        }
    });
}