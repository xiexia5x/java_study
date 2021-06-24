package com.heima.impl;

import com.heima.AccountService;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class AccountServiceImpl  implements AccountService {

    public AccountServiceImpl() {
        System.out.println("AccountService1 create....");
    }

    @Override
    public void add() {
        System.out.println("add run....");
    }

    public void initAccountService(){
        System.out.println("initAccountService run....");
    }

    public void destroyAccountService(){
        System.out.println("destroyAccountService run...");
    }

}
