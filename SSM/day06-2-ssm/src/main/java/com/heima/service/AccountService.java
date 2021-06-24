package com.heima.service;

import com.github.pagehelper.PageInfo;
import com.heima.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    /**
     *
     * @param curPage 当前页
     * @param pageSize 每页大小
     * @return
     */
    PageInfo<Account> findAll(Integer curPage, Integer pageSize);

    boolean insertAccount(Account account);

    boolean deleteAccount(Integer id);

    Boolean updateAccount(Account account);
}
