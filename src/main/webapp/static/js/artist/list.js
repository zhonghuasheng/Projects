$(document).ready(function(){
    pagination();
});

function pagination(currentPage, pageSize, key) {
    var cPage = 1;
    var pSize = 10;
    var k = '';

    if (typeof currentPage !== "undefined") {
        cPage = currentPage;
    }

    if (typeof pageSize !== "undefined") {
        pSize = pageSize;
    }

    if (typeof key !== "undefined") {
        k = key;
    }

    $.ajax({
        type: 'post',
        async: true, // 异步请求。（同步请求会锁住浏览器，用户的其他操作必须等待请求完成才能执行）
        url: '/musicstore/admin/artist/list',
        data: {
            'currentPage': cPage,
            'pageSize': pSize,
            'key': k,
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
    // 只有一页
    if (result.totalPage < 2) {
        return;
    } else {
        var p = '<li class="page-item"><a class="page-link" href="#">首页</a></li><li class="page-item"><a class="page-link" href="#">&laquo;</a></li>';
        var e = '<li class="page-item"><a class="page-link" href="#">&raquo;</a></li><li class="page-item"><a class="page-link" href="#">尾页</a></li>';
        var m = '';

        if (1 <= result.totalPage && result.totalPage <= 9) {
            for (i = 1; i <= result.totalPage; i++) {
                if (i == result.currentPage) {
                    m += '<li class="page-item active"><a class="page-link" href="#">' + i + '</a></li>';
                } else {
                    m += '<li class="page-item"><a class="page-link" href="#">' + i + '</a></li>';
                }
            }
        }

        if (9 < result.totalPage) {
            if (result.currentPage <= 5) {
                for (i = 1; i <= result.totalPage; i++) {
                    if (i == result.currentPage) {
                        m += '<li class="page-item active"><a class="page-link" href="#">' + i + '</a></li>';
                    } else {
                        m += '<li class="page-item"><a class="page-link" href="#">' + i + '</a></li>';
                    }
                }
            } else {
                for (i = result.currentPage - 4; i < result.currentPage; i++) {
                    m += '<li class="page-item"><a class="page-link" href="#">' + i + '</a></li>';
                }

                for (j = result.currentPage; j < result.currentPage + 5; j++) {
                    if (j == result.currentPage) {
                        m += '<li class="page-item active"><a class="page-link" href="#">' + j + '</a></li>';
                    } else {
                        m += '<li class="page-item"><a class="page-link" href="#">' + j + '</a></li>';
                    }
                }
            }
        }

        var pageFooter = $('#page-footer ul');
        pageFooter.empty();
        pageFooter.append(p).append(m).append(e);

         $('#page-footer ul li').on('click', function() {
            $('#page-footer ul li').filter('.active').removeClass('active');
            $(this).addClass('active');
            paging();
        });
    }
}

$('#search').on('click', function() {
    paging();
});

$('#pageSize').on('change', function() {
    paging();
});

function paging() {
    var pageSize = $('#pageSize').val();
    var currentPage = $('#page-footer ul li').filter('.active').find('.page-link').text();
    var key = $('#key').val();
    pagination(currentPage, pageSize, key);
}

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