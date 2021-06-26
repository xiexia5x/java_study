package com.heima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laofang
 * @description
 * @date 2021-06-25
 */
@SpringBootApplication
@MapperScan(basePackages = "com.heima.mapper")
public class MybatisPlusApp {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApp.class,args);
    }
}
