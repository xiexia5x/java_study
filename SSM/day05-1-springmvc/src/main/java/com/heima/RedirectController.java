package com.heima;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试重定向
 * @author laofang
 * @description
 * @date 2021-06-15
 */
@Controller
public class RedirectController {

    /**
     * 使用原生API实现请求的重定向
     * @param response
     */
    @RequestMapping("/test4")
    public void nativeRedirect(HttpServletResponse response) throws IOException {
        System.out.println("nativeRedirect run....");
        //http:localhost:8080/WEB-INF/pages/success.jsp [不能够访问]
//        response.sendRedirect("/WEB-INF/pages/success.jsp");
//        response.sendRedirect("index.jsp");
        //http:localhost:8080/success
//        response.sendRedirect("/success");
        //跨服务器重定向
        response.sendRedirect("https://www.baidu.com/");
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    /**
     * 使用redirect重定向关键字实现请求的重定向操作
     * @return
     */
    @RequestMapping("/test5")
    public String springmvcRedirect(){
        System.out.println("springmvcRedirect run....");
        //等价于 response.sendRedirect("/success");
//        return "redirect:/success";
        return "redirect:https://www.baidu.com/";
    }

}
