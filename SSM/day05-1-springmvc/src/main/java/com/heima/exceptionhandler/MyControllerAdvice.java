package com.heima.exceptionhandler;

import com.heima.exception.BusinessException;
import com.heima.exception.SystemException;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常分类管理器
 * @author laofang
 * @description
 * @date 2021-06-15
 */
@ControllerAdvice
public class MyControllerAdvice {


    /**
     * @ExceptionHandler(BusinessException.class)
     * 表示当前方法只处理BusinessException异常
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public String resolveBusinessException(BusinessException ex){
        // do:安抚用户
        // 记录日志
        String errorMsg = ex.getMessage();
        return errorMsg;
    }

    /**
     * 出现系统异常时，跳转到error.jsp页面
     * @param ex
     * @return
     */
    @ExceptionHandler(SystemException.class)
    public ModelAndView resolveSystemException(SystemException ex){
        // 安抚用户
        // 通知运维人员 调用短信接口 调用邮箱接口 调用站内信
        // 记录日志
        String errorMsg = ex.getMessage();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:/WEB-INF/pages/error.jsp");
        mv.addObject("error",errorMsg);
        return mv;
    }

    //其他异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String resolverException(Exception e){
        String message = e.getMessage();
        return message;
    }



}
