package com.heima.interceptor;

import com.vo.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author laofang
 * @description
 * @date 2021-06-16
 */
public class Loginnterceptor implements HandlerInterceptor {
    /**
     * 在处理器方法执行之前执行
     * @param request
     * @param response
     * @param handler 当前处理器方法的对象 MethodHandler
     * @return
     *          true:
     *              资源放行，当前请求可以访问资源或者下一级的拦截器
     *          false:
     *              资源不放行，也就是不能访问controller下的方法
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        //获取sesion对象
        HttpSession session = request.getSession();
        //获取当前session对应的user属性
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser!=null) {
            //如果用户存在，则资源放行
            return true;
        }else{
             //不存在用户信息时，跳转到登录页面
            response.sendRedirect("/user/loginPage");
            return false;
        }

    }

}
