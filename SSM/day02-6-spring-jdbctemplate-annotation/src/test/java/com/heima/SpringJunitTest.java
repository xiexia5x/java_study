package com.heima;

import com.Address;
import com.heima.config.SpringConfig;
import com.heima.config.User;
import com.heima.pojo.Account;
import com.heima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
@RunWith(SpringJUnit4ClassRunner.class)//指定构造ioc容器的类
//@ContextConfiguration(locations = "classpath:applicatonContext.xml")//指定xml路径
@ContextConfiguration(classes = {SpringConfig.class})//配置spring的配置类
public class SpringJunitTest {
    @Autowired
    private AccountService accountService;

    @Autowired
    private Account myAccount;

    @Autowired
    private Address address;

    @Autowired
    private User user;


    @Test
    public void test()  {
        List<Account> all = accountService.findAll();
        System.out.println(all);
    }

    @Test
    public void test2()  {
        System.out.println(myAccount);
    }

    @Test
    public void test3()  {
        System.out.println(user);
    }

    @Test
    public void test4()  {
        System.out.println(address);
    }
}
