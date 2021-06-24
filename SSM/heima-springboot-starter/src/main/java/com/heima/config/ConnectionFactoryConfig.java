package com.heima.config;

import com.heima.props.RedisConfigProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
//@Configuration
@ConditionalOnClass(JedisConnectionFactory.class)
@EnableConfigurationProperties(RedisConfigProperties.class)
public class ConnectionFactoryConfig {
    private RedisConfigProperties properties;

    public ConnectionFactoryConfig(RedisConfigProperties properties) {
        this.properties = properties;
    }
    @Bean
    @ConditionalOnMissingBean//如果ioc容器中存在工厂ben，则不创建
    public RedisConnectionFactory connectionFactory(){
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(properties.getHostName());
        connectionFactory.setPort(properties.getPort());
        connectionFactory.setDatabase(properties.getDb());
        return connectionFactory;
    }

}
