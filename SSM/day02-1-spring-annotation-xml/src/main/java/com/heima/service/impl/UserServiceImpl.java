package com.heima.service.impl;

import com.heima.dao.UserDao;
import com.heima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
//注解不指定bean的名称时，默认bean的名称时类名且首字符小写
//@Component("userService1")//如果bean不属于web,service,dao，config，那么推荐使用
//@Service("userService1")//业务逻辑层
//@Repository("userService1")//持久层
@Controller("userService1")//web层
//@Scope("singleton")//等同于scope="prototype"
@Scope("prototype")//等同于scope="prototype"
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        System.out.println("UserServiceImpl created ...");
    }

    //    @Value("zhangsan")
//    private String name;
//    @Value("18")
//    private Integer age;
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;

    /**
     * 根据类型自动注入：如果ioc容器中存在UserDao类型的bean，自动注入
     * org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.heima.dao.UserDao' available: expected single matching bean but found 2: userDao1,userDao2
     *  @Autowired
     *      required:
     *          true:表示必须注入成功，否则抛异常
     *          false:非必须注入成功，注入失败，不抛异常
     */
//    @Autowired(required = false)
//    @Qualifier("userDao")
//    private UserDao userDao;


    /**
     * 如果容器中b注入的类型存在多个，那么可以通过将注入的变量的名称与beanid名称一致即可
     *  维护性非常差
     */
//    @Autowired
//    private UserDao userDao2;

    /**
     * 可以通过@Qualifier限制使用哪个bean
     */
//    @Autowired
//    @Qualifier("userDao2")
//    private UserDao userDao;

    /**
     * @Resource等价于@Autowired+@Qualifier("userDao2") 【推荐】
     */
    @Resource(name = "userDao2")
    private UserDao userDao;


    @Override
    public void add() {
        //System.out.println("add run...");
        userDao.add();
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @PostConstruct//等同于init-method="initUserService"
    public void initUserService(){
        System.out.println("initUserService run....");
    }
    @PreDestroy//等同于destroy-method="destroyUserService"
    public void destroyUserService(){
        System.out.println("destroyUserService run....");
    }
}
