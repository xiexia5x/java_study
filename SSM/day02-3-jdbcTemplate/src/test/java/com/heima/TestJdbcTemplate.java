package com.heima;

import com.heima.pojo.Account;
import com.sun.media.sound.SoftTuning;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class TestJdbcTemplate {
    private JdbcTemplate jdbcTemplate;

    @Before
    public void init(){
        //1.定义数据库连接池对象
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setUrl("jdbc:mysql:///ssm");
        //2.创建操纵数据库的模板对象
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 测试添加
     */
    @Test
    public void test1()  {
       String sql="insert into account values(null,?,?)";
        int count = jdbcTemplate.update(sql, "柳岩", 20000f);
        System.out.println(count);
    }
    /**
     * 测试更新
     */
    @Test
    public void test2()  {
       String sql="update account set name=? ,money=? where id=?";
        int count = jdbcTemplate.update(sql, "赵丽颖", 40000f,2);
        System.out.println(count);
    }

    /**
     * 测试查询 --》单行单列
     */
    @Test
    public void test3()  {
       String sql="select name from account where id=?";
        String name = jdbcTemplate.queryForObject(sql, String.class, 2);
        System.out.println(name);
    }

    /**
     * 测试查询 --》单行多列
     */
    @Test
    public void test4()  {
       String sql="select * from account where id=?";
       //返回map key：字段名称，value：字段值
      //Map<String, Object> map = jdbcTemplate.queryForMap(sql, 2);
        //BeanPropertyRowMapper保证查询中sql指定字段名称与pojo类中属性名称一致即可，如果不一致，那么sql中使用as取别名即可
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), 2);
        System.out.println(account);
    }

    /**
     * 测试多行单列
     */
    @Test
    public void test5()  {
        String sql="select id from account";
        List<Integer> ids = jdbcTemplate.queryForList(sql, Integer.class);
        System.out.println(ids);
    }
    /**
     * 测试多行多列
     */
    @Test
    public void test6()  {
        String sql="select * from account";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        List<Account> accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        System.out.println(accounts);
    }

}
