package com.heima.dao;

import com.heima.pojo.Account;

public interface AccountDao {

    Account findById(Integer id);

    Integer moneyOut(Integer accountId,Float money);

    Integer moneyIn(Integer accountId,Float money);

}
