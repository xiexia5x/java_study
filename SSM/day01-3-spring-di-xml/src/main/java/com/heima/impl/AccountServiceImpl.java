package com.heima.impl;

import com.heima.AccountService;
import com.heima.pojo.Account;

import java.util.*;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class AccountServiceImpl  implements AccountService {
    private String name;
    private Integer age;
    private Account account;
    private String[] names;
    private List<Account> accountList;
    private Map<String,Object> maps;
    private Properties properties;
    private Set<String> sets;

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                ", names=" + Arrays.toString(names) +
                ", accountList=" + accountList +
                ", maps=" + maps +
                ", properties=" + properties +
                ", sets=" + sets +
                '}';
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public AccountServiceImpl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public AccountServiceImpl() {
        System.out.println("AccountService1 create....");
    }

    @Override
    public void add() {
        System.out.println("add run....");
    }

}
