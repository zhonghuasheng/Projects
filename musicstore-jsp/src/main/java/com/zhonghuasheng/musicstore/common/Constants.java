package com.zhonghuasheng.musicstore.common;

public class Constants {

    public static final String BLANK = "";

    // User register/create
    public static final String EMPTY_USERNAME = "请输入用户名";
    public static final String EMPTY_EMAIL = "请输入邮箱";
    public static final String INVALID_EMAIL_FORMAT = "请输入正确的邮箱格式";
    public static final String EMPTY_PASSWORD = "请输入密码";
    public static final String INVAILD_PASSWORD_LENGTH = "密码长度必须在6 - 12字符";
    public static final String EMPTY_CONFIRM_PASSWORD = "请再次输入密码";
    public static final String CONFIRM_PASSWORD_NOT_EQUALS_PASSWORD = "两次密码输入不一致";
    public static final String EMAIL_EXISTED = "邮箱已经被注册";
    public static final String INVAILD_BIRTHDAY_FORMAT = "出生日期格式不正确";
    public static final String DEFAULT_USER_AVATAR = "default-user.png";

    // User register/login page
    public static final String REGISTER_PAGE = "/WEB-INF/html/user/register.jsp";
    public static final String LOGIN_PAGE = "/WEB-INF/html/user/login.jsp";

    // Artist create
    public static final String EMPTY_NAME = "请输入姓名";
    public static final Object EMPTY_AVATAR = "请上传图像";
}
