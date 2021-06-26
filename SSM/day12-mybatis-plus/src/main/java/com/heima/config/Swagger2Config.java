package com.heima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author laofang
 * @description
 * @date 2021-06-25
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    //配置swagger2的文档说明对象
    @Bean
    public Docket docket(){
       return   new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指定api扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.heima.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return   new ApiInfoBuilder()
                //页面标题
                .title("mybatisPlus快速入门")
                //描述
                .description("springboot整合mybatisPlus")
                //作者信息
                .contact(new Contact("laofang","http://www.baidu.com","xx@163.com"))
                //版本
                .version("1.0-SNAPSHOT")
                .build();
    }




}
