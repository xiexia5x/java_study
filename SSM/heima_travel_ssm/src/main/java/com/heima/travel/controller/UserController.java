package com.heima.travel.controller;

import com.heima.travel.pojo.User;
import com.heima.travel.service.UserService;
import com.heima.travel.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author laofang
 * @description
 * @date 2021-06-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @param check
     * @param session
     * @return
     */
    @PostMapping("/register")
    public ResultInfo register(User user, String check, HttpSession session){
        //1.获取session中保存的验证码
        String sessionCheckCode = (String) session.getAttribute("CHECK_CODE");
        //2.调用服务层方法，获取响应结果
        ResultInfo result= this.userService.registerUser(user,sessionCheckCode,check);
        return result;
    }
    //不建议将web层的api引入service层的方法入参中
//    @GetMapping("/active")
//    public void activeUser(String code,HttpServletResponse response){
//        this.userService.activeUser(code, response );
//    }

    /**
     * 激活用户
     * @param code
     * @throws IOException
     */
    @GetMapping("/active")
    public void activeUser(String code) throws IOException {
        this.userService.activeUser(code);
    }

    /**
     * 登录功能
     * @param username
     * @param password
     * @param check
     * @return
     */
    @PostMapping("/login")
    public ResultInfo login(String username,String password,String check){
        return this.userService.login(username,password,check);
    }

    @PostMapping("/getLoginUserData")
    public ResultInfo getLoginUserData(){
       return  this.userService.getLoginUserData();
    }

    @GetMapping("/loginOut")
    public void loginOut(){
        this.userService.loginOut();
    }
}
