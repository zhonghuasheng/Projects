package com.zhonghuasheng;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.zhonghuasheng.seckill.util.MD5Util;
import com.zhonghuasheng.seckill.util.ValidatorUtil;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SecKillAppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void md5Equal() {
        String str1 = org.apache.commons.codec.digest.DigestUtils.md5Hex("Abcde12345_");
        String str2 = org.springframework.util.DigestUtils.md5DigestAsHex("Abcde12345_".getBytes());
        System.out.println("org.apache.commons.codec.digest.DigestUtils: " + str1);
        System.out.println("org.springframework.util.DigestUtils:" + str2);
        /**
         * org.apache.commons.codec.digest.DigestUtils: 4e8c736c62f543615b8a96ac469c8399
         * org.springframework.util.DigestUtils:4e8c736c62f543615b8a96ac469c8399
         */
        assertTrue( str1.equals(str2) );
    }

    @Test
    public void testMD5() {
        System.out.println(MD5Util.inputPass2FormPass("123456"));//cf4e3dc14922120e4f714a37576f17fb
        String pass = MD5Util.inputPass2DBPass("123456", "Abcde12345_");
        System.out.println(pass); // 1e5b9e011dfde95eb0a12c7dd3e40645
        assertTrue(true);
    }

    @Test
    public void isMobile() {
        assertTrue(ValidatorUtil.isMobile("18668686868"));
    }

    @Test
    public void isNotMobile() {
        assertFalse(ValidatorUtil.isMobile("186"));
    }
}
