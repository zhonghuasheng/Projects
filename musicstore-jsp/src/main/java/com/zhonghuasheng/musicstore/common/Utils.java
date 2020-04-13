package com.zhonghuasheng.musicstore.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * General methods for judging
 * @author luke.chen
 *
 */
public class Utils {

    private static Pattern emailAddressPattern = Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");

    public static boolean isNullOrEmpty(Object object) {
        return object == null || String.valueOf(object).trim().length() == 0;
    }

    public static boolean assertEquals(Object obj1, Object obj2) {
        if ((obj1 == null) || (obj2 == null)) {
            return false;
        } else {
            return obj1.equals(obj2);
        }
    }

    public static boolean isEmailAddressFormat(String object) {
        Matcher matcher = emailAddressPattern.matcher(object);

        return matcher.matches();
    }
}
