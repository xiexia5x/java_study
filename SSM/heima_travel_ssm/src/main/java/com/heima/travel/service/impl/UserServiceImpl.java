package com.heima.travel.service.impl;

import com.heima.travel.mapper.UserMapper;
import com.heima.travel.pojo.User;
import com.heima.travel.service.UserService;
import com.heima.travel.utils.MailUtil;
import com.heima.travel.utils.Md5Util;
import com.heima.travel.utils.UuidUtil;
import com.heima.travel.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author laofang
 * @description
 * @date 2021-06-19
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public ResultInfo registerUser(User user, String sessionCheckCode, String check) {
        //1.验证注册码与session下的注册码是否一致
        if (check==null || !check.equalsIgnoreCase(sessionCheckCode)) {
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码有误");
            return resultInfo;
        }
        //2.查询当前用户是否已经注册 TODO 异步验证用户名是否存
        User dbUser=this.userMapper.findUserByUserName(user.getUsername());
        if (dbUser!=null) {
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名已经注册");
            return resultInfo;
        }
        //3.添加用户
        //3.1 将密码加密处理 TODO 双层加密+盐
        user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
        //3.2 设置用户状态为未激活
        user.setStatus("N");
        //3.3 设置激活用户的激活码
        String activeCode= UuidUtil.getUuid();
        user.setCode(activeCode);
        //4.插入用户信息 TODO 将激活码存储到redis中，key为insert插入后回填的主键值，value为激活码
        //user.getUid()--->获取回填的主键值，jedis.set(id,activeCode)
        this.userMapper.insertUser(user);
        //5.发送邮箱
        //5.1 设置正文
        String content="<a href='http://localhost:8080/user/active?code="+activeCode+"'>点击激活</a>";
        //5.2 发送邮箱
        MailUtil.sendMail(user.getEmail(),content);
        return new ResultInfo(true,null,null);
    }

    @Override
    public void activeUser(String code) throws IOException {
        //1.激活用户
        Integer count= this.userMapper.activeUser(code);
        if (count>0) {
            //如果受影响行数大于0，说明激活成功。此时需要资源跳转login.html页面下 ThreadLocal
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
            response.sendRedirect("/login.html");
        }else{
            //todo 用于全局异常统一处理
            throw new RuntimeException("邮箱激活失败！");
        }
    }


    @Override
    public ResultInfo login(String username, String password, String check) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //获取当前会话的session
        HttpSession session = ((ServletRequestAttributes) requestAttributes).getRequest().getSession();
        String sessionCheckCode = (String)session.getAttribute("CHECK_CODE");
        if (check==null || ! check.equalsIgnoreCase(sessionCheckCode)) {
            return new ResultInfo(false,"验证码错误");
        }
        //根据用户和密码查询用户是否存在
        User dbUser= this.userMapper.findUserByUserNameAndPassword(username,Md5Util.encodeByMd5(password));
        if (dbUser==null) {
            return new ResultInfo(false,"用户名或者密码错误");
        }
        //如果用户存在，则将用户的信息保存到session下
        session.setAttribute("CUR_USER",dbUser);
        return new ResultInfo(true,null,null);
    }

    @Override
    public ResultInfo getLoginUserData() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //获取当前会话的session
        HttpSession session = ((ServletRequestAttributes) requestAttributes).getRequest().getSession();
        User curUser = (User) session.getAttribute("CUR_USER");
        if (curUser==null) {
            return new ResultInfo(false,"当前用户未登录");
        }
        return new ResultInfo(true,curUser,null);
    }

    @Override
    public void loginOut() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //获取当前会话的session
        ServletRequestAttributes sra=((ServletRequestAttributes) requestAttributes);
        HttpServletResponse response = sra.getResponse();
        HttpServletRequest request = sra.getRequest();
        HttpSession session = request.getSession();
        //销毁session中存储的用户信息
        session.removeAttribute("CUR_USER");
        //退出后退出原来页面
        String preUrl = request.getHeader("referer");
        try {
            response.sendRedirect(preUrl);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("退出错误");
        }
    }
}
