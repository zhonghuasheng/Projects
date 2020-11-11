package com.zhonghuasheng.ms.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.spring.boot.client.MatrixToImageWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class QRCodeUtil {

    /**
     * 根据URL生成指定fileName的二维码图片
     * 二维码图片保存在resources/qrcode中
     * @param url url作为二维码内容
     * @param filePath 生成文件全路径
     */
    public static void qrCode(String url, String filePath, String fileName) {
        int width = 300, height =  300;
        String format = "png";
        // 定义二维码参数
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        // 定义字符集编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        // 定义二维码的容错率，容错率越高二维码的有效像素点越高
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 定义图片边距
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
            File file = new File(filePath + fileName + "." + format);
            MatrixToImageWriter.writeToFile(bitMatrix, format, file);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}
