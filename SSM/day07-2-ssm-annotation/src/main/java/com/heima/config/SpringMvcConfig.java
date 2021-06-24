package com.heima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author laofang
 * @description
 * @date 2021-06-18
 */
@Configuration
@ComponentScan(value = "com.heima.controller")
@EnableWebMvc//开启springmvc注解驱动支持，等价于<mvc:annotation-driven/>
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * 配置视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //设置视图解析器解析视图的前缀路径
        viewResolver.setPrefix("/WEB-INF/pages/");
        //设置视图解析器解析视图的后缀
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 配置静态资源不被拦截
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//释放静态资源不被拦截，等价于<mvc:default-servlet-handler/>
    }
}
