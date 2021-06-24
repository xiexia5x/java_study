package com.heima.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
@ConfigurationProperties(prefix = "init.redis")
@Data
public class RedisConfigProperties {
    private String hostName="localhost";
    private Integer port=6379;
    private Integer db=0;
}
