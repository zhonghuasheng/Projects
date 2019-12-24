$().ready(function() {
    $("#music-create").validate({
        rules: {
            title: "required"
        },
        messages: {
            title: "请输入音乐名"
        }
    });
});
