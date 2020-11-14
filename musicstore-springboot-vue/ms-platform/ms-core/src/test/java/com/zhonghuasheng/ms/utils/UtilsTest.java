package com.zhonghuasheng.ms.utils;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void testQrCode() {
        QRCodeUtil.qrCode("content", System.getProperty("user.dir") + "/bucket/xxx/", "987654321");
    }
}
