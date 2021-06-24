package com.heima.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        //1.定义数据库连接池对象
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setUrl("jdbc:mysql:///ssm");
        //2.创建操纵数据库的模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //3.删除操作
        String deleteSql="delete from account where id=?";
        //返回受影响行数
        int count = jdbcTemplate.update(deleteSql, 5);
        System.out.println(count);
    }
}
