package com.heima.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author laofang
 * @description
 * @date 2021-06-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {
    //请求结果是否成功
    private boolean isSuccess;
    //响应提示信息
    private String message;
    //正常请求的数据
    private Object data;
}
