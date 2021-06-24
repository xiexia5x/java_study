package com.heima.controller;

import com.github.pagehelper.PageInfo;
import com.heima.pojo.Account;
import com.heima.service.AccountService;
import com.heima.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-16
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/all")
    public Result findAll(){
//        System.out.println("findAll");
//        Account a1 = Account.builder().id(1).money(100f).name("张三").build();
//        Account a2 = Account.builder().id(2).money(101f).name("张三2").build();
        List<Account> all = accountService.findAll();
        Result result = Result.builder().data(all).isSuccess(true).build();
        return result;
    }

    @RequestMapping("/{curPage}/{pageSize}")
    public List<Account> findPage(@PathVariable("curPage") Integer curPage,
                                  @PathVariable("pageSize") Integer pageSize){
        PageInfo<Account> pageInfo = this.accountService.findAll(curPage, pageSize);
        List<Account> list = pageInfo.getList();
        return list;
    }
    @PostMapping("/account")
    public Boolean addAccount(@RequestBody Account account){
       boolean isSuccess=  this.accountService.insertAccount(account);
       return isSuccess;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteAccount(@PathVariable("id") Integer id){
        boolean isSuccess= this.accountService.deleteAccount(id);
        return  isSuccess;
    }

    @PutMapping("/{name}/{money}/{id}")
    public Boolean updateAccount(@PathVariable("name") String name,
                                 @PathVariable("money") Float money,
                                 @PathVariable("id") Integer id){
        Account account = Account.builder().id(id).name(name).money(money).build();
        Boolean isSuccess= this.accountService.updateAccount(account);
        return isSuccess;
    }


}
