package com.heima.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author laofang
 * @description
 * @date 2021-06-13
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        //逻辑视图
        return "hello";
    }
}
