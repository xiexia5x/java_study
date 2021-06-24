package com.heima;

import com.heima.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
@Configuration//配置类，等价于xml配置文件
//@ComponentScan(basePackages = "com.heima") //<context:component-scan base-package="com.heima"/>
@ComponentScan //<context:component-scan base-package="com.heima"/>
@PropertySource(value = "classpath:bean.properties",encoding = "UTF-8") // <context:property-placeholder location="classpath:bean.properties" file-encoding="UTF-8"/>
public class SpringConfig {


    /**
     * 如果没有指定bean对应的名称，那么就是默认使用方法名
     * @return
     */
    @Bean("user")
    public User user(){
        User user = new User();
        user.setName("赵丽颖");
        user.setAge(18);
        return user;
    }
}
