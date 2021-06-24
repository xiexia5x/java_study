package com.heima.service.impl;

import com.heima.service.UserService;

/**
 * @author laofang
 * @description
 * @date 2021-06-12
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add run....");
    }

    @Override
    public void update() {
        //模拟异常，触发异常通知
//        int a=10/0;
        System.out.println("update run....");

    }

    @Override
    public void delete() {
        System.out.println("delete run....");
    }

    @Override
    public String query(String name) {
        int a=10/0;
        System.out.println("query run...."+name);
        return name;
    }
}
