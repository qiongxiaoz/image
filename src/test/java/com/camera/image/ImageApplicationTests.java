package com.camera.image;

import com.camera.image.util.HttpUtil;
import com.camera.image.util.ImageUtils;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URLDecoder;
import java.net.URLEncoder;

@SpringBootTest
class ImageApplicationTests {


    public static void main(String[] args) throws Exception {

        byte[] data = ImageUtils.getImageStr("https://t7.baidu.com/it/u=4162611394,4275913936&fm=193&f=GIF");
        String image = Base64.encodeBase64String(data);

        StringBuilder builder = new StringBuilder();
        builder.append("type=image")
                .append("&image="+image)
                .append("&userCode=0AB5")
                .append("&teamCode=09877689");

        String result = HttpUtil.httpRequest("http://localhost:8080/image/forward","POST",
                builder.toString());
        System.out.println(result);
    }
}
