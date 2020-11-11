package com.zhonghuasheng.ms.utils;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void testQrCode() {
        QRCodeUtil.qrCode("http://www.baidu.com/", System.getProperty("user.dir") + "/bucket/qrcode", "baidu");
    }
}
