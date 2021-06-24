package com.heima.travel.service;

import com.heima.travel.pojo.User;
import com.heima.travel.vo.ResultInfo;

import java.io.IOException;

public interface UserService {
    ResultInfo registerUser(User user, String sessionCheckCode, String check);

    void activeUser(String code) throws IOException;

    ResultInfo login(String username, String password, String check);

    ResultInfo getLoginUserData();

    void loginOut();
}
