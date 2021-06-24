package com.heima.factory;

import com.heima.AccountService;
import com.heima.impl.AccountServiceImpl;

/**
 * 调用getInstance()获取的userservice对象被ioc容器管理
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class InstanceFactory {

    public  AccountService getInstance(){
        return new AccountServiceImpl();
    }
}
