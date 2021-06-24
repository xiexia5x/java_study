package com.proxy.jdk;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class Tesla implements Car {
    @Override
    public void color() {
        System.out.println("金色的tesla,6666");
    }

    @Override
    public void run() {
        System.out.println("xxx");//1.方法之前 2.插入什么样的代码
        System.out.println("根本停不下来.....");

    }
}
