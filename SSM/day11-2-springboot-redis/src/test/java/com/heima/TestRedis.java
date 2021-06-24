package com.heima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.lang.model.element.VariableElement;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
@SpringBootTest
public class TestRedis {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 测试value
     */
    @Test
    public void test1()  {
       redisTemplate.opsForValue().set("name","张三3");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    /**
     * 测试list
     */
    @Test
    public void test2()  {
       redisTemplate.opsForList().leftPushAll("address","上海","北京");
        List<Object> address = redisTemplate.opsForList().range("address", 0, -1);
        System.out.println(address);
    }

    /**
     * 测试hash
     */
    @Test
    public void test3()  {
       redisTemplate.opsForHash().put("info","name","张三");
       redisTemplate.opsForHash().put("info","age",18);
        Map<Object, Object> mapInfo = redisTemplate.opsForHash().entries("info");
        System.out.println(mapInfo);
    }

    @Test
    public void test4()  {
        //存值
       redisTemplate.opsForZSet().add("class129","张海洋",100l);
       redisTemplate.opsForZSet().add("class129","张海洋4",60l);
       redisTemplate.opsForZSet().add("class129","张海洋2",10l);
       redisTemplate.opsForZSet().add("class129","张海洋3",50l);
       //取：根据分数范围取值
        Set<Object> names = redisTemplate.opsForZSet().rangeByScore("class129", 55l, 100l);
        System.out.println(names);
    }

    /**
     * 测试set
     */
    @Test
    public void test5()  {
       redisTemplate.opsForSet().add("music","dj","rock","classic");
        Set<Object> music = redisTemplate.opsForSet().members("music");
        System.out.println(music);
    }
}
