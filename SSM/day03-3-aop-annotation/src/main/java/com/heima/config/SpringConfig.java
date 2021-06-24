package com.heima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author laofang
 * @description
 * @date 2021-06-12
 */
@Configuration
@ComponentScan(basePackages = "com.heima")
@EnableAspectJAutoProxy//开启aop注解支持，等价于 <aop:aspectj-autoproxy/>
public class SpringConfig {
}
