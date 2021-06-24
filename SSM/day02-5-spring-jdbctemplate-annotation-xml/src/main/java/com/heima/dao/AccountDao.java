package com.heima.dao;

import com.heima.pojo.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
}
