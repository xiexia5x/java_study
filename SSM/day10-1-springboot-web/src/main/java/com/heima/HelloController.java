package com.heima;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@RestController
public class HelloController {

//    @Value("${company.name}")
//    private String name1;
//    @Value("${company.name2}")
//    private String  name2;


    @GetMapping("/hi")
    public String hi(){
        return "hello springboot!";
    }

//    @GetMapping("/getName")
//    public String getName(){
//        return name1+"---"+name2;
//    }
}
