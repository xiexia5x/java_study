package com.heima.dao;

import com.heima.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface AccountDao {
    List<Account> findAll();
}
