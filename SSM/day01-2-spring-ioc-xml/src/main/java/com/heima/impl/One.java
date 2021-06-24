package com.heima.impl;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class One {
    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "One{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
