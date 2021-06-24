package com.heima.dao;

import org.springframework.stereotype.Repository;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
@Repository("userDao2")
public class UserDaoImpl2 implements UserDao {
    @Override
    public void add() {
        System.out.println("userDao2 add run...");
    }
}
