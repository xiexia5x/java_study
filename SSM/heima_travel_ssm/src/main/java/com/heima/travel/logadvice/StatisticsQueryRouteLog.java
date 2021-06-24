package com.heima.travel.logadvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author laofang
 * @description
 * @date 2021-06-20
 */
@Component
@Aspect
public class StatisticsQueryRouteLog {

    private static final Logger LOGGER= LoggerFactory.getLogger(StatisticsQueryRouteLog.class);

    //声明切入点方法
    //不能增强的原因：增强的切面类属于父容器，而被增强的对象属于子容器，同时子容器也未开启aop注解支持
    //解决：1.在子容器维护切面类对象 2.在子容器开启aop注解支持 【了解】
//    @Pointcut("execution(public * com.heima.travel.controller.RouteController.find*(..))")
//    public void pt(){}

    //推荐在服务层做增强
    @Pointcut("execution(public * com.heima.travel.service.RouteService.find*(..))")
    public void pt(){}

    //配置环绕通知
    @Around("pt()")
    public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
        //获取方法名称
        String methodName = pjp.getSignature().getName();
        LOGGER.info("{}方法执行了...",methodName);
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        LOGGER.info("{}方法执行耗时为：{}",methodName,System.currentTimeMillis()-start);
        return result;
    }


}
