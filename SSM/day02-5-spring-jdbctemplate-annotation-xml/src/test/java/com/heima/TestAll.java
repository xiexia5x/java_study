package com.heima;

import com.heima.pojo.Account;
import com.heima.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
        AccountService accountService = ctx.getBean("accountService", AccountService.class);
        List<Account> all = accountService.findAll();
        System.out.println(all);
    }

    @Test
    public void test2()  {
        Account myAccount = ctx.getBean("myAccount", Account.class);
        System.out.println(myAccount);
    }

}
