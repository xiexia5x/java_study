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
public class TestScope {

    private ApplicationContext ctx;
    @Before
    public void init(){
       ctx=new ClassPathXmlApplicationContext("applicationContext-scope.xml");
    }

    /**
     * 测试单例
     */
    @Test
    public void test1()  {
        for (int i = 0; i < 10; i++) {
            AccountService accountService2 = ctx.getBean("accountService1", AccountService.class);
            System.out.println(accountService2);
        }
    }

    /**
     * 测试单例
     */
    @Test
    public void test2()  {
        for (int i = 0; i < 10; i++) {
            AccountService accountService2 = ctx.getBean("accountService2", AccountService.class);
            System.out.println(accountService2);
        }
    }



}
