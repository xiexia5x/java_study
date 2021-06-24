package com.heima.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@Data
public class Woman {
    private String userName;
    private Integer age;
    private List<String> addresses;
}
