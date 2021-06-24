package com.heima.service.impl;

import com.heima.dao.AccountDao;
import com.heima.pojo.Account;
import com.heima.service.AccountService;

import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
