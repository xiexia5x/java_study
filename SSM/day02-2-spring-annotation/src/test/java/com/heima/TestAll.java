package com.heima;

import com.Account;
import com.heima.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class TestAll {
    private ApplicationContext ctx;
//    @Before
//    public void init(){
//        ctx=new ClassPathXmlApplicationContext("applicationContext.xml.bak");
//    }
    @Before
    public void init(){
        ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
    }

    @Test
    public void test1()  {
        UserService userService1 = ctx.getBean("userService1", UserService.class);
        userService1.add();
        System.out.println(userService1);

        ((ClassPathXmlApplicationContext)ctx).close();
    }

    @Test
    public void test2()  {
        UserService userService1 = ctx.getBean("userService1", UserService.class);
        userService1.add();
        System.out.println(userService1);
    }

    @Test
    public void test3()  {
        Account bean = ctx.getBean(Account.class);
        System.out.println(bean);
    }
}
