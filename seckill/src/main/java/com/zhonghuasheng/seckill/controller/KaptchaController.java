package com.zhonghuasheng.seckill.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/kaptcha")
public class KaptchaController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public void getKaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        // 生成验证码字符串并保存到session中
        String createText = defaultKaptcha.createText();
        request.getSession().setAttribute("rightCode", createText);
        // 将验证码字符串返回一个BufferedImage对象并转为byte写入
        BufferedImage image = defaultKaptcha.createImage(createText);
        try {
            ImageIO.write(image, "jpg", jpegOutputStream);
        } catch (IOException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}

