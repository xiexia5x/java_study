package com.heima.pojo;

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
public class Account {
    private  Integer id;
    private String name;
    private Float money;
}
