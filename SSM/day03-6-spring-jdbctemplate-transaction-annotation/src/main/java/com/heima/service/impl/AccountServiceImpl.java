package com.heima.service.impl;

import com.heima.dao.AccountDao;
import com.heima.pojo.Account;
import com.heima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author laofang
 * @description
 * @date 2021-06-12
 */
@Service("accountService")
// <tx:method name="*" read-only="false" propagation="REQUIRED"/>
//@Transactional作用到类上，表示类中所有方法的事务策略都是指定方式运行
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)//主流
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    //只针对运行时异常进行回滚 RuntimeException
    //
    //rollbackFor = Exception.class指定发生异常的需要进行回顾的异常类型
    //定义非运行时异常也可以回滚,需要显式指定回滚的类型
    @Transactional(rollbackFor = {IOException.class, FileNotFoundException.class})
//    @Transactional
    @Override
    public Boolean transfer(Integer fromId, Integer toId, Float money) throws IOException {
        //打印显式转账相关人员的信息
        Account fromAccount = accountDao.findById(fromId);
        System.out.println("转账人信息："+fromAccount.toString());
        Account toAccount = accountDao.findById(toId);
        System.out.println("收账人信息："+fromAccount.toString());
        //转出
        Integer fromCount = accountDao.moneyOut(fromId, money);
        //int a=10/0;//模拟转账异常
        if (true) {
            throw new IOException();
        }
        //转入
        Integer toCount = accountDao.moneyIn(toId, money);
        return (fromCount>0&&toCount>0);
    }

    /**
     * @Transactional 【就近原则】
     * 作用于方法上时，当前方法就会采用方法上的事务策略
     * @return
     */
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public String findUserName(){
        return "userName";
    }
}
