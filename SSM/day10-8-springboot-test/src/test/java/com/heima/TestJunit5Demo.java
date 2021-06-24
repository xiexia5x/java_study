package com.heima;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.TimeUnit;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@DisplayName("单元测试5核心测试API")
public class TestJunit5Demo {

    @Test
    @DisplayName("前置测试")
    public void beforeCondition(){
        int c=add(3,2);//5
//        Assumptions.assumeTrue(c==5,"测试值与期望值6不相同");
        assumeTrue(c==5,"测试值与期望值6不相同");
        //断言类
//        Assertions.assertEquals(5,c,"获取的值与真实值不符");
        assertEquals(5,c,"获取的值与真实值不符");
    }
    public int add(int a,int b){
        return a+b;
    }


    @Test
    @DisplayName("测试期望值")
    public void assertArray(){
        Object target = new Object();
        Object tagert2=target;
        assertEquals(target,tagert2,"两个对象不相同");
    }

    @Test
    @DisplayName("组合断言")
    public  void all() {
        /**
         * 所有断言全部需要成功
         */
        assertAll("test",
                () -> assertTrue(true && true, "结果不为true"),
                () -> assertEquals(1, 1, "结果不是1"));

        System.out.println("=====");
    }

    @DisplayName("异常断言")
    @Test
    public void testException() {
        String str=null;
        //断定业务逻辑一定出现异常
        assertThrows(ArithmeticException.class, () -> {
//            int i = 10 / 0;
            str.equals("xx");
        }, "业务逻辑居然正常运行？");
    }

    @DisplayName("快速失败")
    @Test
    public void testFail(){
        //xxxxx
        if(1 == 1){
            fail("测试失败");
        }
    }


    @Disabled
    @DisplayName("测试方法2")
    @Test
    public  void test2() {
        System.out.println(2);
    }

    /**
     * 重复测试5次
     */
    @RepeatedTest(5)
    @Test
    public void test3() {
        System.out.println(5);
    }

    /**
     * 规定方法超时时间。超出时间测试出异常
     *
     * @throws InterruptedException
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test//jupiter对应的注解
    public  void testTimeout() throws InterruptedException {
        Thread.sleep(400);
    }

}
