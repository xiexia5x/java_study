package com.heima;

import com.heima.impl.One;
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
       ctx=new ClassPathXmlApplicationContext("applicationContext-createType.xml");
    }

    /**
     * 测试静态工厂创建bean
     */
    @Test
    public void test1()  {
        AccountService accountService2 = ctx.getBean("accountService2", AccountService.class);
        accountService2.add();
    }

    /**
     * 测试非静态工厂创建bean
     */
    @Test
    public void test2()  {
        AccountService accountService2 = ctx.getBean("accountService3", AccountService.class);
        accountService2.add();
    }
    /**
     * 测试非静态工厂创建bean
     */
    @Test
    public void test3()  {
        One one = ctx.getBean("one", One.class);
        System.out.println(one);
    }
}
