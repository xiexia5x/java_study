package com.heima.config;

import com.heima.pojo.Account;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.AccessibleObject;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class MyConfig {

    @Bean
    public Account myAccount(){
        Account account = new Account();
        account.setId(1);
        account.setName("王五1");
        account.setMoney(199999f);
        return account;
    }
}
