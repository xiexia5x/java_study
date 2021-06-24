package com.heima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@RestController
public class AccountController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/all")
    public List getAll(){
        String sql="select * from account";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
}
