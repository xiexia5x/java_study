package com.heima.config;

import com.heima.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

//    @Autowired
//    private MyInterceptor myInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")//拦截所有
        .excludePathPatterns("/**/*.css","/**/*.jpg","/**/*.js");
    }
}
