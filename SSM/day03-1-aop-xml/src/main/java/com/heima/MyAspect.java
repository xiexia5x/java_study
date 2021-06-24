package com.heima;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类/增强类/通知类
 * 增强的代码封装到切面类的某个方法下
 * @author laofang
 * @description
 * @date 2021-06-12
 */
public class MyAspect {

    public void beforeAdvice(){
        System.out.println("前置增强运行了。。。。。");
    }

    public void afterReturningAdvice(){
        System.out.println("后置增强运行了。。。。。");
    }
    public void afterThrowingAdvice(){
        System.out.println("异常增强运行了。。。。。");
    }
    public void afterAdvice(){
        System.out.println("最终增强运行了。。。。。");
    }

    /**
     * ProceedingJoinPoint:处理切入点的类，底层封装了要增强的方法
     * @param pjp
     */
    public void aroundAdvice(ProceedingJoinPoint pjp){
        //获取方法的入参
        Object[] args = pjp.getArgs();
        //调用方法执行
        try {
            //前置增强
            System.out.println(Arrays.toString(args));
            System.out.println("前置增强运行了");
            pjp.proceed();
            System.out.println("后置增强运行了");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常增强运行了");
        }finally {
            System.out.println("最终通知运行了");
        }
        // pjp.proceed(args);
    }

}
