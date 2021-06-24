package com.heima.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author laofang
 * @description
 * @date 2021-06-13
 */
@Data
public class User {
    private Integer age;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
