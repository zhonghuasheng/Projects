$().ready(function() {
    $("#register").validate({
        rules: {
            username: "required",
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 12
            },
            confirmPassword: {
                required: true,
                equalTo: "#password"
            }
        },
        messages: {
            username: "请输入用户名",
            email: {
                required: "请输入邮箱",
                email: "输入的邮箱格式不正确"
            },
            password: {
                required: "请输入密码",
                minlength: "密码长度必须在6 - 12字符",
                maxlength: "密码长度必须在6 - 12字符"
            },
            confirmPassword: {
                required: "请再次输入密码",
                equalTo: "两次密码输入不一致"
            }
        }
    });
});
