package com.heima.travel.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * 验证类
 * @author laofang
 * @description
 * @date 2021-06-19
 */
@Controller
public class ValidateController {


    @GetMapping("/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置浏览器禁止当前数据缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");
        //2.创建图片内存对象
        int width=80;
        int height=30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //3.获取画笔对象
        Graphics gh = image.getGraphics();
        //4.设置图片的背景颜色
        gh.setColor(Color.gray);
        //填充图片颜色
        gh.fillRect(0,0,width,height);
        //5.生成随机数:策略，长度为5.由数字和字母组成
        String checkCode = RandomStringUtils.randomAlphanumeric(5);
        //存入session key:CHECK_CODE  TODO 把验证码存放到redis中，并设置失效时间
        request.getSession().setAttribute("CHECK_CODE",checkCode);
        //6.将验证码画入图片对象
        gh.setColor(Color.yellow);
        gh.setFont(new Font("黑体",Font.BOLD,24));
        gh.drawString(checkCode,15,25);
        //7.将图片对象发送给浏览器
        /**
         * 参数一：图片对象
         * 参数二：图片后缀
         * 参数三：写出流，发送到浏览器下
         */
        ImageIO.write(image,"PNG",response.getOutputStream());

    }
}
