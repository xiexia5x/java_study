package com.heima.factory;

import com.heima.dao.UserDao;
import com.heima.dao.impl.UserDaoImpl;
import com.heima.dao.impl.UserDaoImpl2;

/**
 * 使用工厂模式：
 *  好处：引用方都通过工厂获取实例对象，这样方案做调整时，只需修改工厂即可（代码的改动量少）
 *  问题：
 *      1.虽然解决了dao与service之前的耦合，但是引入的新的耦合
 *      2.耦合：工厂与dao存在耦合
 *   如何解决？
 *      工厂模式+静态资源配置
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class UserDaoFactory {


    /**
     * 生成UserDao接口的实现类的对象的
     * @return
     */
    public static UserDao getInstance(){
        return new UserDaoImpl();
//        return new UserDaoImpl2();
    }
}
