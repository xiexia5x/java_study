package com.heima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heima.dao.AccountDao;
import com.heima.pojo.Account;
import com.heima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-16
 */
@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Account> findAll() {
        List<Account> all = accountDao.findAll();
        return all;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageInfo<Account> findAll(Integer curPage, Integer pageSize) {
        //设置当前页和每页大小
        PageHelper.startPage(curPage,pageSize);
        List<Account> list = accountDao.findAll();
        PageInfo<Account> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean insertAccount(Account account) {
        Integer count= this.accountDao.insert(account);
        return count>0;
    }

    @Override
    public boolean deleteAccount(Integer id) {
        Integer count=  this.accountDao.deleteById(id);
        return count>0;
    }

    @Override
    public Boolean updateAccount(Account account) {
        Integer count= this.accountDao.updateUser(account);
        return count>0;
    }
}
