package com.heima;

import com.heima.config.SpringConfig;
import com.heima.pojo.Account;
import com.heima.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class TestAll {
    private ApplicationContext ctx;
    @Before
    public void init(){
    //ctx=new ClassPathXmlApplicationContext("applicationContext.xml.bak");
        ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
    }

    @Test
    public void test1()  {
        AccountService accountService = ctx.getBean("accountService", AccountService.class);
        List<Account> all = accountService.findAll();
        System.out.println(all);
    }

}
