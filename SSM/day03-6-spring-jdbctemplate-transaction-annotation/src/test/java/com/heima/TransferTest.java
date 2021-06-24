package com.heima;

import com.heima.config.SpringConfig;
import com.heima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author laofang
 * @description
 * @date 2021-06-12
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml.bak")
@ContextConfiguration(classes = SpringConfig.class)
public class TransferTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void test1() throws IOException {
       Integer fromId=1;
       Integer toId=2;
       Float money=200F;
        Boolean isSuccess = accountService.transfer(fromId, toId, money);
        System.out.println(isSuccess?"转账成功":"转账失败");
    }
}
