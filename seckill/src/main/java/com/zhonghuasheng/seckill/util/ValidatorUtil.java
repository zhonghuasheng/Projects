package com.zhonghuasheng.seckill.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {

    private static final Pattern MOBILE_PATTERN = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Matcher m = MOBILE_PATTERN.matcher(str);

        return m.matches();
    }
}
