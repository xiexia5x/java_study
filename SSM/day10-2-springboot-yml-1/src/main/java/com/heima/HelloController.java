package com.heima;

import com.heima.pojo.Man;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private Integer age;

    @Value("${addresses[1]}")
    private String address;

    @Value("${msg1}")
    private String msg1;

    @Value("${msg2}")
    private String msg2;

    @Value("${msg3}")
    private String msg3;

    @Value("${name}")
    private String userName;

    @Autowired
    private Man man;


    @GetMapping("/hi")
    public String hi(){
        return name+":"+age+":"+address;
    }

    @GetMapping("/msg")
    public String getMsg(){
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);
        System.out.println(userName);
        System.out.println(man);
        return "msg";
    }

}
