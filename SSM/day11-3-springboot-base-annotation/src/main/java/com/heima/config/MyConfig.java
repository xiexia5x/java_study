package com.heima.config;

import com.heima.pojo.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.AccessControlContext;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */

/**
 * @Configuration
 *  proxyBeanMethods
 *      true: 默认值，表示代理配置类下的方法，每次执行，都返回相同的bean对象 FULL模式 单例模式
 *      false:表示配置类中方法不被代理，每次调用方法，都会返回新的对象 LITE模式 多例模式
 */
//@Configuration(proxyBeanMethods=false)
public class MyConfig {
//    @Bean//单例
//    public Account account(){
//        Account account = Account.builder().id(1).userName("张三").money(100f).build();
//        return account;
//    }
}
