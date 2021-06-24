package com.heima;

import com.github.pagehelper.PageHelper;
import com.heima.dao.AccountDao;
import com.heima.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
@SpringBootTest
public class TestMybatis {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void test1()  {
        PageHelper.startPage(1,2);
        List<Account> all = accountDao.findAll();
        System.out.println(all);
    }
}
