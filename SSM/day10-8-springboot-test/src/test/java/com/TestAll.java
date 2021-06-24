package com;

import com.heima.InterceptorApplication;
import com.heima.service.UserServiceImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NavigableMap;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@SpringBootTest
@RunWith(SpringRunner.class)//必须指定
//junit4整合springboot 约定：测试类要与springboot启动类同路径或者子路径下
//如何解决？
@ContextConfiguration(classes = InterceptorApplication.class)
public class TestAll {

    @Before
    public void before(){
        System.out.println("before run....");
    }

    /**
     * 测试类被加载时只运行一次
     */
    @BeforeClass
    public static void beforeAll(){
        System.out.println("beforeAll run...");
    }


    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test1()  {
        String name = userService.getName();
        System.out.println(name);
    }

    @Test
    public void test2()  {
        System.out.println("test2 run....");
    }

    @After
    public void after(){
        System.out.println("after run....");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class run....");
    }
}
