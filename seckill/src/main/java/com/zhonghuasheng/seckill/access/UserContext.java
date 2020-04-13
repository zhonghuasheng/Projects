package com.zhonghuasheng.seckill.access;

import com.zhonghuasheng.seckill.domain.SecKillUser;

public class UserContext {

    private static ThreadLocal<SecKillUser> userHolder = new ThreadLocal<SecKillUser>();

    public static void setUser(SecKillUser user) {
        userHolder.set(user);
    }

    public static SecKillUser getUser() {
        return userHolder.get();
    }
}
