package com.heima.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author laofang
 * @description
 * @date 2021-06-16
 */
public class MyInterceptor2 implements HandlerInterceptor {
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
        System.out.println("preHandle2 run...");
        HandlerMethod method= (HandlerMethod) handler;
        //获取方法对象
        Method controllerMethod = method.getMethod();
        //获取方法名称
        String methodName = controllerMethod.getName();
        System.out.println("方法："+methodName+"准备运行");
        String servletPath = request.getServletPath();
        if (servletPath.equals("/user/update")) {
            //此时放回fass时，对/user/update对应的controller下的方法不能访问
            return false;
        }

        return true;
    }

    /**
     * 在处理器方法执行之后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 通过该参数可以动态修改处理器响应的视图
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle2 run....");

    }

    /**
     *
     * @param request
     * @param response
     * @param handler 处理器方法对象
     * @param ex 可能出现的异常
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("afterCompletion2 run....");
    }
}
