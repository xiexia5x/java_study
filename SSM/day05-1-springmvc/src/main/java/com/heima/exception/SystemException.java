package com.heima.exception;

/**
 * 定义系统异常，一般是编译器检查异常
 * @author laofang
 * @description
 * @date 2021-06-15
 */
public class SystemException  extends Exception{
    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
