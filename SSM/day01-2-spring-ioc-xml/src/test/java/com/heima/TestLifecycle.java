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
public class TestLifecycle {

    private ApplicationContext ctx;
    @Before
    public void init(){
       ctx=new ClassPathXmlApplicationContext("applicationContext-lifecycle.xml");
    }

    /**
     * 测试单例
     */
    @Test
    public void test1()  {
        AccountService service1 = ctx.getBean("accountService1", AccountService.class);
        AccountService service2 = ctx.getBean("accountService1", AccountService.class);
        service1.add();
        //关闭容器，调用bean的destroy指定的销毁方法
        ClassPathXmlApplicationContext ctx2= (ClassPathXmlApplicationContext) ctx;
        ctx2.close();
    }
    /**
     * 测试多例下生命周期
     */
    @Test
    public void test2()  {
        AccountService service1 = ctx.getBean("accountService2", AccountService.class);
        AccountService service2 = ctx.getBean("accountService2", AccountService.class);
        service1.add();
        //关闭容器，调用bean的destroy指定的销毁方法
        ClassPathXmlApplicationContext ctx2= (ClassPathXmlApplicationContext) ctx;
        ctx2.close();
    }



}
