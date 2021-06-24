package com.heima.travel.mapper;

import com.heima.travel.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User findUserByUserName(@Param("name") String username);

    void insertUser(User user);

    Integer activeUser(@Param("code") String code);

    User findUserByUserNameAndPassword(@Param("name") String username,@Param("password") String encodeByMd5);
}
