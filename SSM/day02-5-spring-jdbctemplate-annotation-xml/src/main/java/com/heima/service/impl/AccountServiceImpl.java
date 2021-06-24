package com.heima.service.impl;

import com.heima.dao.AccountDao;
import com.heima.pojo.Account;
import com.heima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
