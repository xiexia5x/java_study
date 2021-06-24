package com.heima.dao;

import org.springframework.stereotype.Repository;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
@Repository("userDao1")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("userDao1 add run...");
    }
}
