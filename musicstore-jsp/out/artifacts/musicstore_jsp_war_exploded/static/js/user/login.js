$().ready(function() {
    $("#login").validate({
        rules: {
            email: "required",
            password: "required"
        },
        messages: {
            email: "请输入邮箱",
            password:  "请输入密码"
        }
    });
});
