package com.heima.travel.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author laofang
 * @description
 * @date 2021-06-20
 */
@ControllerAdvice
public class HandlerExceptionAdvice {

    private static final Logger LOGGER= LoggerFactory.getLogger(HandlerExceptionAdvice.class);

    @ExceptionHandler(RuntimeException.class)
    public void handlerRuntimeException(RuntimeException ex, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //todo log4j打印日志--》日志文件
       // System.out.println(ex.getMessage());
        //获取当前请求的url地址
        String curUrl = request.getRequestURI();
        //获取错误信息
        String errorMsg = ex.getMessage();
        LOGGER.info("用户访问：{},报错：{}",curUrl,errorMsg);
        response.sendRedirect("/error.html");
    }

}
