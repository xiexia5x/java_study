package com.heima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author laofang
 * @description
 * @date 2021-06-18
 */
@Configuration
@ComponentScan(value = "com.heima",
        //排除指定注解对应的bean
        excludeFilters = @ComponentScan.Filter(
                //基于注解排除
                type = FilterType.ANNOTATION,
                classes = {
                        Controller.class,
                        RestController.class,
                        ControllerAdvice.class,
                        RestControllerAdvice.class
                }

        ))
@EnableAspectJAutoProxy//开启aop支持
@EnableTransactionManagement//开启事务支持
public class SpringConfig {
}
