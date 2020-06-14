package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
 *@params com.leyou
 *@description 网关服务的启动类
 *@auth huchongyuan
 *@create 2020-04-30 21:
 */
@EnableZuulProxy
@SpringCloudApplication
public class LyGateway {
    public static void main(String[] args) {
        SpringApplication.run(LyGateway.class,args);
    }
}
