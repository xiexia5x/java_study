package com.heima.dao.impl;

import com.heima.dao.UserDao;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class UserDaoImpl2 implements UserDao {
    @Override
    public void add() {
        System.out.println("add2 run....");
    }

    @Override
    public void delete() {
        System.out.println("delete2 run....");
    }
}
