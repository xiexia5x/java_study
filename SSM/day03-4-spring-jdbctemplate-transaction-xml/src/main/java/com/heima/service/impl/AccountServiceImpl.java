package com.heima.service.impl;

import com.heima.dao.AccountDao;
import com.heima.pojo.Account;
import com.heima.service.AccountService;

/**
 * @author laofang
 * @description
 * @date 2021-06-12
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Boolean transfer(Integer fromId, Integer toId, Float money) {
        //打印显式转账相关人员的信息
        Account fromAccount = accountDao.findById(fromId);
        System.out.println("转账人信息："+fromAccount.toString());
        Account toAccount = accountDao.findById(toId);
        System.out.println("收账人信息："+fromAccount.toString());
        //转出
        Integer fromCount = accountDao.moneyOut(fromId, money);
        int a=10/0;//模拟转账异常
        //转入
        Integer toCount = accountDao.moneyIn(toId, money);
        return (fromCount>0&&toCount>0);
    }
}
