package com.heima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot依赖配置：
 *  1.定义了常用的资源版本，并进行了版本锁定，对于开发者来说，无需关心版本的依赖冲突问题
 *  2.定义了资源和插件的各种版本，对于开着者，直接使用即可
 *  3.定义了50多个通用的场景启动器，简化开发配置
 * @author laofang
 * @description
 * @date 2021-06-22
 */
@SpringBootApplication//表示当前类是springboot的启动类/引导类
//@EnableConfigurationProperties(value = Man.class)
public class ProfileApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProfileApplication.class,args);
    }
}
