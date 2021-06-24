package com.heima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laofang
 * @description
 * @date 2021-06-16
 */
@RestController
public class UserController {

    @GetMapping("/user/add")
    public String addUser(){
        System.out.println("addUser run....");
        return "addUser";
    }


    @GetMapping("/user/update")
    public String updateUser(){
        System.out.println("updateUser run....");
        return "updateUser";
    }


    @GetMapping("/user/query")
    public String queryUser(){
        System.out.println("queryUser run....");
        return "queryUser";
    }

}
