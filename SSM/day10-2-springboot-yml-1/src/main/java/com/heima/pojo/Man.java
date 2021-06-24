package com.heima.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@Data
//绑定配置文件中指定的key
@ConfigurationProperties(prefix = "init.man")
@Component
public class Man {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private String[] address;
    private List<String> addressList;
    private Map<String, Object> hobbies;  // 爱好
    private Woman woman;
    private List<Woman> wifes;
}
