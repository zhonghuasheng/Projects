$().ready(function() {
    $("#music-create").validate({
        rules: {
            title: "required"
        },
        messages: {
            username: "请输入音乐名"
        }
    });
});
