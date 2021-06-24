package com.heima;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
@SpringBootApplication
@RestController
@EnableAdminServer
public class AdminServer {
    public static void main(String[] args) {
        SpringApplication.run(AdminServer.class,args);
    }

    @GetMapping("/getName")
    public String  getName(){
        return "王五";
    }
}
