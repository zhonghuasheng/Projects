package com.zhonghuasheng.seckill.util;


import org.springframework.util.DigestUtils;

public class MD5Util {

    public static String md5(String str) {
        // 使用spring框架的DigestUtils，减少pom中的依赖
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    private static final String salt = "Abcde12345_";

    public static String inputPass2FormPass(String str) {
        String mixStr = String.valueOf(salt.charAt(0)) + String.valueOf(salt.charAt(2))
                + str + String.valueOf(salt.charAt(1)) + String.valueOf(salt.charAt(3));
        return md5(mixStr);
    }

    public static String formPass2DbPass(String str, String salt) {
        String mixStr = salt.charAt(0) + salt.charAt(2) + str + salt.charAt(1) + salt.charAt(3);
        return md5(mixStr);
    }

    public static String inputPass2DBPass(String str, String saltDb) {
        String formPass = inputPass2FormPass(str);
        return formPass2DbPass(formPass, saltDb);
    }
}
