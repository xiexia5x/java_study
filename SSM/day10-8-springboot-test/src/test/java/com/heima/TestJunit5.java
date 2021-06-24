package com.heima;

import com.heima.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@SpringBootTest
public class TestJunit5 {
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void test1()  {
        String name = userService.getName();
        System.out.println(name);
    }
}
