package com.heima.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author laofang
 * @description
 * @date 2021-06-13
 */
@Data
public class CollectionVo {
    private List<String> names;
    private List<User> users;
    private Map maps;
}
