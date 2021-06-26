package com.heima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.mapper.UserMapper;
import com.heima.pojo.User;
import com.heima.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author laofang
 * @description
 * @date 2021-06-25
 */
@Service("userService")
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {

}
