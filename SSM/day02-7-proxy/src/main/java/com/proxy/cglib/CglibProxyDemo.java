package com.proxy.cglib;

import com.proxy.jdk.notarget.UserService;
import jdk.internal.org.objectweb.asm.tree.MethodNode;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class CglibProxyDemo {
    /**
     * cglib:原理是通过动态为目标对象创建一个子类，并重写父类方法方法的增强
     * 所以目标对象对应的类不能被final修饰，否则无法增强
     * @param args
     */
    public static void main(String[] args) {
        //1。创建目标对象
         AccountService accountService = new AccountService();
        //2.创建代理对象
        AccountService accountServiceProxy = (AccountService) Enhancer.create(accountService.getClass(), new MethodInterceptor() {
            /**
             *
             * @param proxy 代理对象 【开发慎用】
             * @param method 当前执行的方法对象
             * @param args 方法参数
             * @param methodProxy 方法的代理对象 【开发慎用】
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                Object result = null;
                String methodName = method.getName();
                try {
                    //前置增强/前置通知
                    System.out.println(methodName + "运行了。。。。");
                    result = method.invoke(accountService, args);
                    int a=10/0;
                    //后置增强/后置通知
                    System.out.println(methodName + "执行完毕");
                } catch (Exception e) {
                    e.printStackTrace();
                    //异常增强/异常通知
                    System.out.println(methodName + "出异常了");
                } finally {
                    //最终增强/最终通知
                    System.out.println(methodName + "最终执行完了");
                }

                return result;
            }
        });
        accountServiceProxy.add();
    }
}

