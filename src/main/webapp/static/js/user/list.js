$(document).ready(function(){
    /*
     * menu part
     */

    /*adds click event on menu item li*/
    $('#pagination').bootstrapPaginator({
        bootstrapMajorVersion:4,
        //pageInfo.pageNum是当前页面的页码
        currentPage:1,
        //pageInfo.pages是总页数
        totalPages:10,
        //配置页面跳转函数，向后端传入数据，发送跳转请求,
        //type：选择的页码所显示的文字，如第一页默认type为first
        //page:选择的页码
        //current：当前页码
        pageUrl:function(type,page,current)
        {
            return '/musicstore/admin/user/search?pageNum='+page;
        },

        itemTexts:function(type,page, current)
        {//文字翻译
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "尾页";
                case "page":
                    return page;
            }
        },
        onPageClicked: function (event, originalEvent, type, page) {
            console.log(page);
        }
    });

    /* searches artists by keywords */
    $('.app-search_button').on('click', function() {
        $.ajax({
            url: '/musicstore/admin/artist/',
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