package com.heima.mapper;

import com.heima.pojo.Account;

public interface AccountMapper {
    //根据主键删除
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}