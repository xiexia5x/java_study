package com.heima.exceptionhandler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author laofang
 * @description
 * @date 2021-06-15
 */
//@Component
public class MyHandlerExceptionResolver  implements HandlerExceptionResolver {
    /**
     *
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 出现异常的处理器对象
     * @param ex 出现的异常对象
     * @return ModelAndView 出现异常时
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        //使用基于接口的方式处理的异常，不方便进行异常分类管理
//        if (ex instanceof NullPointerException){
//            //do something
//        }
//        else if(ex instanceof IndexOutOfBoundsException){
//            //do something
//        }
        //........
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",ex.getMessage());
        mv.setViewName("forward:/WEB-INF/pages/error.jsp");
        return mv;
    }
}
