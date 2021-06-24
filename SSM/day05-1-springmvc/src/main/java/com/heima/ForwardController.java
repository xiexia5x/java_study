package com.heima;

import com.heima.exception.BusinessException;
import com.heima.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 测试转发请求
 * @author laofang
 * @description
 * @date 2021-06-15
 */
@Controller
public class ForwardController {


    /**
     * 请求转发与重定向区别？
     *   请求转发：
     *      1.请求转发是一次请求的延续，浏览器地址栏只显示第一次访问到url
     *      2.请求转发是服务器内部的请求行为；
     *      3.请求转发是request对象的行为；
     *      4.请求转发可以共享request域下的数据；
     *   重定向：
     *      1.重定向是多次请求，浏览器地址栏显示最后一次请求的url；
     *      2.重定向可以跨服务器请求；
     *      3.请求转发是response对象的行为；
     *      4.重定向不可以共享request域下的数据；
     */


    /**
     * 测试原生API实现转发
     */
    @RequestMapping("/test1")
    public void nativeForward(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {
        System.out.println("nativeForward run....");
        //请求转发的地址可以是jsp资源的物理路径，也可以是springmvc提供的handler地址
       // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        request.getRequestDispatcher("/test2").forward(request,response);
    }

    @RequestMapping("/test2")
    public String success(){
        int a=10/0;
        System.out.println("success run.....");
        return "success";
    }

    /**
     * 使用forward请求转发的关键字实现请求转发
     * @return
     */
    @RequestMapping("/test3")
    public String springForward(){
        System.out.println("springForward run....");
//        return "forward:/WEB-INF/pages/success.jsp";
        return "forward:/test2";
    }


    /**
     * 模拟注册
     * 改接口正常访问的话，不可能传来小于7的数据。因为前段进行校验
     * @param name
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(String name){
        //业务要求：昵称长度必须大于7
        if (name==null|| name.length()<7) {
            throw new BusinessException("name length gt 7");
        }
        return name;
    }

    /**
     * 模拟系统异常
     * @return
     * @throws SystemException
     */
    @RequestMapping("/linkdb")
    public String register() throws SystemException {
        if (true) {
            try {
                throw new SQLException();
            } catch (SQLException exception) {
                exception.printStackTrace();
                throw new SystemException("数据库连接异常");
            }
        }
        return "success";

    }


    @RequestMapping("/ex")
    public String ex() throws Exception {
        if (true) {
            throw new Exception("exception run...");
        }
        return "success";

    }




}
