package com.heima.config;

import com.heima.pojo.Account;
import com.heima.pojo.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownServiceException;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
@Configuration
//指定某个类存在，则加载配置类，加入ioc容器中
//@ConditionalOnClass(value = User.class)
//@ConditionalOnClass(name = "com.heima.pojo.User2")
//指定容器中如果不存在指定类型的bean，那么就将配置类加入ioc容器
//@ConditionalOnMissingBean(User.class)
//指定容器中如果存在指定类型的bean，那么就将配置类加入ioc容器
//@ConditionalOnBean(User.class)
//配置文件中必须有 init.user前缀，且key为name的属性，那么才加载配置类，加入ioc容器
@ConditionalOnProperty(prefix = "init.user",name = "name")
public class MyCondition {
    @Bean//单例
    public Account account(){
        Account account = Account.builder().id(1).userName("张三").money(100f).build();
        return account;
    }
}
