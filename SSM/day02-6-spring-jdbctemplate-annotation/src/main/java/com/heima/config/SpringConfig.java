package com.heima.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
@Configuration
@PropertySource(value = "classpath:jdbc.properties",encoding = "UTF-8")
@ComponentScan(basePackages = "com.heima")
//@Import({MyConfig.class})
@Import({User.class,MyConfig.class,MyImportSelector.class})
public class SpringConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.user}")
    private String userName;
    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Bean("dataSource")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(userName);
        dataSource.setDriverClassName(driverClass);
        return dataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource());
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }


}
