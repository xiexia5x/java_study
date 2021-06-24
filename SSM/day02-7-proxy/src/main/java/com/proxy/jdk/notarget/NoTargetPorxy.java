package com.proxy.jdk.notarget;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class NoTargetPorxy {
    public static void main(String[] args) {
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
                UserService.class.getClassLoader(),
                //自行组装接口的字节码对象数组
                new Class[]{UserService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        System.out.println(name + "执行了");
                        if (name.equals("add")) {
                            System.out.println("获取xml中add对应的sql，然后通过jdbc发送给数据库");
                        }
                        return null;
                    }
                }
        );

//        userServiceProxy.delete();
        userServiceProxy.add();
    }
}
