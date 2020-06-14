package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 *@params com.leyou
 *@description 注册中心
 *@auth huchongyuan
 *@create 2020-04-30 21:
 */
@EnableEurekaServer
@SpringBootApplication
public class LyRegistry {
    public static void main(String[] args) {
        SpringApplication.run(LyRegistry.class,args);
    }
}
