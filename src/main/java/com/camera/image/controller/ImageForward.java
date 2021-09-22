package com.camera.image.controller;

import com.camera.image.util.ImageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@RestController
@RequestMapping(value = "image")
public class ImageForward  {

    private static final Logger LOG = LoggerFactory.getLogger(ImageForward.class);



    /**
     *@Author t接收照片
     *@Description
     */
    @RequestMapping(value = "forward")
    public void getUserFund(HttpServletRequest request, HttpServletResponse response){
        try{
                //类型 默认image
                String type = request.getParameter("type");
                //用户唯一码
                String userCode = request.getParameter("userCode");
                //团队唯一码
                String teamCode = request.getParameter("teamCode");
                //照片数据 base64
                String value = request.getParameter("image").replaceAll(" ","+").trim();
                //自定义照片存储
                ImageUtils.generateImageFromBase64(value,"/usr/local/image/test.jpg");

                response.setContentType("application/json;charset=UTF-8");
                OutputStream os = response.getOutputStream();
                os.write("{\"status\":0}".getBytes());
                os.flush();
                os.close();
       } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }




}
