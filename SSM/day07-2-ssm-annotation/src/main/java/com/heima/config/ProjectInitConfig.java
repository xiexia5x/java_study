package com.heima.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author laofang
 * @description
 * @date 2021-06-18
 */
public class ProjectInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 配置父容器初始化需要的配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class,MybatisConfig.class};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        //注册过滤器扩展
        FilterRegistration.Dynamic dynamic = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        //设置过滤器的init参数
        dynamic.setInitParameter("encoding","UTF-8");
        dynamic.setInitParameter("forceRequestEncoding","true");
        dynamic.setInitParameter("forceResponseEncoding","true");
        //设置过滤器拦截规则
        // true:表示所有过滤器过滤之后再执行
        dynamic.addMappingForUrlPatterns(null,true,"/*");

    }

    /**
     * 配置子容器的配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 配置核心控制器的拦截规则
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
