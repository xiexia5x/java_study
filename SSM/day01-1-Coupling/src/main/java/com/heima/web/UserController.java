package com.heima.web;

import com.heima.factory.BeanFactory;
import com.heima.factory.UserServiceFactory;
import com.heima.service.UserService;
import com.heima.service.impl.UserServiceImpl;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class UserController {
    /**
     * 模拟web
     * @param args
     */
    public static void main(String[] args) {
//        UserService userService=new UserServiceImpl();
//        UserService userService= UserServiceFactory.getInstance();
        //存在的问题：调用一次getInstance方法，就创建一次，大量浪费内存
        //如何解决：维护一个存储对象的集合，结构：map  key--》instance
        UserService userService= (UserService) BeanFactory.getInstance("userService");
        UserService userService2= (UserService) BeanFactory.getInstance("userService");
        System.out.println(userService);
        System.out.println(userService2);
        userService.add();
    }
}
