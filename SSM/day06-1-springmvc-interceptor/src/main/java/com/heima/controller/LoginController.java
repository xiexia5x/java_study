package com.heima.controller;

import com.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Struct;

/**
 * @author laofang
 * @description
 * @date 2021-06-16
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(User user, HttpSession session){
        System.out.println(user);
        if (StringUtils.isEmpty(user.getUserName())|| StringUtils.isEmpty(user.getPassword())) {
            return "forward:/user/loginPage";
        }
        //将用户信息保存到session下
        session.setAttribute("loginUser",user);
        return "forward:/user/success";
    }

    /**
     * 要求：只有登录成功才能访问success.jsp页面
     * @return
     */
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
