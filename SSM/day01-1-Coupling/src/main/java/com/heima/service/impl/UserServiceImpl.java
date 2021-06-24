package com.heima.service.impl;

import com.heima.dao.UserDao;
import com.heima.dao.impl.UserDaoImpl;
import com.heima.dao.impl.UserDaoImpl2;
import com.heima.factory.BeanFactory;
import com.heima.factory.UserDaoFactory;
import com.heima.service.UserService;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class UserServiceImpl implements UserService {
    /**
     * 问题：
     * 耦合：
     *  add()功能的实现强依赖于UserDaoImpl类，我们就说add方法与UserDaoImpl存在耦合
     *  UserDao接口对应的实现被若干第三方引用，那么一旦方案发生修改，那么需要进行大量的代码的调整
     *  如何解决？
     */
    @Override
    public void add() {
        // UserDao userDao= new UserDaoImpl();
//        UserDao userDao= new UserDaoImpl2();
//        UserDao userDao= UserDaoFactory.getInstance();
        //约定获取userDao对象对应的key
        UserDao userDao= (UserDao) BeanFactory.getInstance("userDao");
        userDao.add();
    }

    @Override
    public void delete() {
//        UserDao userDao= UserDaoFactory.getInstance();
        UserDao userDao= (UserDao) BeanFactory.getInstance("userDao");
        userDao.delete();
    }
}
