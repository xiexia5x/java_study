package com.heima;

import com.heima.config.MyCondition;
import com.heima.config.MyConfig;
import com.heima.config.MyImportBeanDefinitionRegistrar;
import com.heima.config.MyImportSelector;
import com.heima.pojo.Account;
import com.heima.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.util.Map;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
@SpringBootApplication
//方式1：作用将指定类作为bean加入ioc容器 beanName:类的全限定名称
//@Import(Account.class)
//方式2：导入配置类，配置类中的生成bean的方法，也会执行，产生bean被ioc容器管理
//@Import(MyConfig.class)
//方式3：导入自定义的导入选择器
//@Import(MyImportSelector.class)
//方式4：导入自定义的bean注册对象
//@Import(MyImportBeanDefinitionRegistrar.class)
public class AnnoBaseApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AnnoBaseApp.class, args);
//        Map<String, MyConfig> b1 = ctx.getBeansOfType(MyConfig.class);
//        System.out.println(b1);
//        Map<String, Account> b2 = ctx.getBeansOfType(Account.class);
//        System.out.println(b2);

//        MyConfig myConfig = ctx.getBean(MyConfig.class);
//        Account a1 = myConfig.account();
//        Account a2 = myConfig.account();
//        System.out.println(a1==a2);

//        Map<String, MyConfig> bc = ctx.getBeansOfType(MyConfig.class);
//        System.out.println(bc);
//
//        Map<String, Account> ba = ctx.getBeansOfType(Account.class);
//        System.out.println(ba);


//        Map<String, Account> b1 = ctx.getBeansOfType(Account.class);
//        Map<String, User> u1 = ctx.getBeansOfType(User.class);
//        System.out.println(b1);
//        System.out.println(u1);

//        User myUser = ctx.getBean("myUser", User.class);
//        System.out.println(myUser);

//        Account a = ctx.getBean(Account.class);
//        System.out.println(a);
        MyCondition bean = ctx.getBean(MyCondition.class);
        System.out.println(bean);


    }

//    @Bean
//    public User user(){
//        return new User();
//    }
}
