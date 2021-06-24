package com.heima;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class TestAll {

    private ApplicationContext ctx;
    @Before
    public void init(){
       ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * 测试构造函数注入
     */
    @Test
    public void test1()  {
        AccountService accountService1 = ctx.getBean("accountService1", AccountService.class);
        System.out.println(accountService1);
    }
    /**
     * 测试setter注入
     */
    @Test
    public void test2()  {
        AccountService accountService2 = ctx.getBean("accountService2", AccountService.class);
        System.out.println(accountService2);
    }



}
