package com.heima.factory;

import com.heima.service.UserService;
import com.heima.service.impl.UserServiceImpl;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class UserServiceFactory {

    public static UserService getInstance(){
        return new UserServiceImpl();
    }
}
