package com.leyou;/*
 *@params com.leyou
 *@description 文件上传启动类
 *@auth huchongyuan
 *@create 2020-05-21 13:
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LyUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyUploadApplication.class,args);
    }
}
