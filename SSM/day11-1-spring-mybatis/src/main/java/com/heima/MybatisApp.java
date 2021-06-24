package com.heima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
@SpringBootApplication
//如果不想在dao接口打@Mapper注解，可以使用接口扫描的方式
@MapperScan("com.heima.dao")
public class MybatisApp {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApp.class,args);
    }
}
