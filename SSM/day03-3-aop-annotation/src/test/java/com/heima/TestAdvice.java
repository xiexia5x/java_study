package com.heima;

import com.heima.config.SpringConfig;
import com.heima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author laofang
 * @description
 * @date 2021-06-12
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml.bak")
@ContextConfiguration(classes = SpringConfig.class)
public class TestAdvice {
    @Autowired
    private UserService userService;

    @Test
    public void test1()  {
        userService.query("zhangsan");
    }
}