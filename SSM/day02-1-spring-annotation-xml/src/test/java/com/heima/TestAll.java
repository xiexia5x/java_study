package com.heima;

import com.heima.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.config.CronTask;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class TestAll {
    private ClassPathXmlApplicationContext ctx;
    @Before
    public void init(){
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test1()  {
        UserService userService1 = ctx.getBean("userService1", UserService.class);
        userService1.add();
        System.out.println(userService1);
        ctx.close();
    }
}
