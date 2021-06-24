package com.heima;

import org.junit.jupiter.api.*;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@DisplayName("测试单元测试5的API")
public class TestJunit5Api {
    @BeforeAll//等价于@BeforeClass
    public static void beforeAll(){
        System.out.println("beforeAll run....");
    }

    /**
     * 每个测试方法运行都执行一次，等价于@Before
     */
    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach run....");
    }

    @Test
    public void test1()  {
        System.out.println("test1 run....");
    }
    @Test
    public void test2()  {
        System.out.println("test2 run....");
    }
    @AfterEach //等价于@After
    public void afterEach(){
        System.out.println("after each run...");
    }

    @AfterAll //等价于@AfterClass
    public static void afterAll(){
        System.out.println("afterAll run....");
    }

}
