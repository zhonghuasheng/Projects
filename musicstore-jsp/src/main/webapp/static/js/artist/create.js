$().ready(function() {
    $("#artist-create").validate({
        rules: {
            avatar: "required",
            name: "required"
        },
        messages: {
            avatar: "",
            name: "请输入姓名"
        }
    });
});
