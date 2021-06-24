package com.heima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@Configuration
public class DataSoruce {

//    @Bean
//    public DataSource dataSource(){
//        HikariDataSource data = new HikariDataSource();
//        data.setUsername("root");
//        data.setJdbcUrl("jdbc:mysql:///ssm");
//        data.setPassword("1234");
//        data.setDriverClassName("com.mysql.jdbc.Driver");
//        return data;
//    }

    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql:///ssm");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1234");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return druidDataSource;
    }
}
