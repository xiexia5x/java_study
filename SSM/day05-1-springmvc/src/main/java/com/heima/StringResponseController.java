package com.heima;

import com.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应前端ajax异步请求
 * @author laofang
 * @description
 * @date 2021-06-15
 */
@Controller
public class StringResponseController {

    /**
     * 使用原生API响应字符串
     */
    @RequestMapping("/test6")
    public void nativeResponse(HttpServletResponse response) throws IOException {
        //1.设置响应给浏览器的内容格式
        //response.setContentType("text/plain;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>native test !!</h1>");
    }


    /**
     * 使用springmvc响应字符串
     * produces = "text/plain;charset=utf-8"
     * 等价于response.setContentType("text/plain;charset=utf-8");
     * @return
     */
//    @RequestMapping(value = "/test7",produces = "text/plain;charset=utf-8")
    @RequestMapping(value = "/test7",produces = "text/html;charset=utf-8")
    @ResponseBody//等价于使用response对象将方法返回的字符串响应给浏览器
    public String springmvcResponse(){
        return "<h1>native test !!</h1>";
    }

    /**
     * springmvc响应vo类型，底层会将vo转化成json格式的字符串
     * 前提：
     *  1.导入jackson相关的依赖
     *  2.开启springmvc注解驱动支持
     * @return
     */
    @RequestMapping("/test8")
    @ResponseBody
    public User responseVo(){
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        //json==>{name:zhangsan,id:1}
        return user;
    }



}
