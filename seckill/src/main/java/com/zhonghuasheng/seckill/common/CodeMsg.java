package com.zhonghuasheng.seckill.common;

public class CodeMsg {

    private int code;
    private String msg;

    // 通用错误码
    public static final CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static final CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务器异常");
    public static final CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常: %s");
    public static final CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "请求非法");
    public static final CodeMsg VERIFY_FAILED = new CodeMsg(500103, "验证失败");
    public static final CodeMsg ACCESS_LIMIT_REACHED = new CodeMsg(500104, "访问太频繁");
    // 登陆模块5002XX
    public static final CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static final CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登陆密码不能为空");
    public static final CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static final CodeMsg MOBILE_FORMAT_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static final CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg(500214, "密码错误");
    //商品模块5003XX
    //订单模块5004XX
    public static final CodeMsg ORDER_NOT_EXIST = new CodeMsg(500400, "订单不存在");
    //秒杀模块5005XX
    public static final CodeMsg SECKILL_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
    public static final CodeMsg REPEATE_SECKILL = new CodeMsg(500501, "不能重复秒杀");

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        String message = String.format(this.msg, args);
        return new CodeMsg(this.code, message);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
