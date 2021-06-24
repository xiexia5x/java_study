package com.heima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
@SpringBootTest
public class TestMyStarter {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Test
    public void test1()  {
        System.out.println(redisConnectionFactory);
        redisTemplate.opsForValue().set("class",129);
        Object  aClass =  redisTemplate.opsForValue().get("class");
        System.out.println(aClass);
    }
}
