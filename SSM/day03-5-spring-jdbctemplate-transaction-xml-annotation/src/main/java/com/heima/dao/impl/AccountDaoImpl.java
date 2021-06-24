package com.heima.dao.impl;

import com.heima.dao.AccountDao;
import com.heima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author laofang
 * @description
 * @date 2021-06-12
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findById(Integer id) {
        String sql="select * from account where id=?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), id);
        return account;
    }

    @Override
    public Integer moneyOut(Integer accountId, Float money) {
        String sql="update account set money=money-? where id=?";
        int count = jdbcTemplate.update(sql, money, accountId);
        return count;
    }

    @Override
    public Integer moneyIn(Integer accountId, Float money) {
        String sql="update account set money=money+? where id=?";
        int count = jdbcTemplate.update(sql, money, accountId);
        return count;
    }
}
