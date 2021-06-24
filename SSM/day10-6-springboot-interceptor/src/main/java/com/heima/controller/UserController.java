package com.heima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@RestController
public class UserController {

    @GetMapping("/getName")
    public String getName(){
        return "zhangsan";
    }
}
