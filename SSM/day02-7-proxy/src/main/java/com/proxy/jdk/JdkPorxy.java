package com.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class JdkPorxy {
    public static void main(String[] args) {
        //1.创建一个目标对象：被代理对象 target：目标对象
        Tesla tesla = new Tesla();
        //2.通过jdk提供的Porxy类和InvocationHandler接口实现 proxy:代理对象
        Car carProxy = (Car) Proxy.newProxyInstance(
                tesla.getClass().getClassLoader(),
                tesla.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy 代理对象 【开发慎用】
                     * @param method 当前调用的方法对象
                     * @param args 方法参数
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String mName = method.getName();
                        System.out.println(mName + "执行了....");
                        if (mName.equals("run")) {
                            System.out.println("开车需谨慎，亲人两行泪");
                        }
                        Object result = method.invoke(tesla, args);

                        return result;
                    }
                }
        );

//        carProxy.color();
        carProxy.run();

    }
}
