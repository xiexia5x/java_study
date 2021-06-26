package com.heima.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.mapper.UserMapper;
import com.heima.pojo.User;
import com.heima.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-25
 */
@Api(tags = "用户操纵User的接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @ApiOperation(value = "用户添加的接口")
    @ApiImplicitParam(name = "user",value = "用户对象信息",required = true,dataType = "com.heima.pojo.User")
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Boolean deleteByUserId(@PathVariable("id")Long id){
        boolean isSuccess = userService.removeById(id);
        return isSuccess;
    }

    /**
     * 用户更新
     * @param user
     * @return
     */
    @PutMapping("/user")
    public boolean updateUser(@RequestBody User user){
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getId,user.getId());
       return userService.update(user,wrapper);
    }

    /**
     * 根据id 查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findByUserId(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return user;
    }

    /**
     * 根据分页和姓名模糊查询
     * @param curPage
     * @param pageSize
     * @param userName
     * @return
     */
    @GetMapping("/{curPage}/{pageSize}/{userName}")
    public List<User> findPage(
            @PathVariable("curPage") Integer curPage,
            @PathVariable("pageSize") Integer pageSize,
            @PathVariable("userName")String userName){
        //1.创建分页对象
        Page<User> page = new Page<>(curPage, pageSize);
        //2.查询条件对象
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class);
        queryWrapper.like(User::getUserName,userName);
        userService.page(page, queryWrapper);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        return page.getRecords();
    }




}
