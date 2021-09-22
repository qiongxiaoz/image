package com.camera.image.util;

import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * @program: ImageUtils
 * @description:
 * @author: markCamera
 * @date: 2021/9/22:14:26
 **/
public class ImageUtils {

    // base64字符串转化成图片
    public static void generateImageFromBase64(String imgStr, String path) {
        // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return ;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpg图片
            // String imgFilePath = "d://222.jpg";//新生成的图片
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
        } catch (Exception e) {
        }
    }

    /**
     * 根据图片地址转换为base64编码字符串
     * @param imgFile
     * @return
     */
    public static byte[] getImageStr(String imgFile) {
        InputStream input = null;
        byte[] data = null;
        try {
            input = HttpUtil.httpsRequestForimage(imgFile, "GET", null, null, 0);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
