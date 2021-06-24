package com.heima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@SpringBootTest
public class TestJdbc {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test1()  {
       String sql="select * from account";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
        Assertions.assertEquals(6,maps.size(),"查询记录与实际不符");
    }
}
