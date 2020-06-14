package com.leyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
 *@params com.leyou.config
 *@description 全局跨域过滤器配置
 *@auth huchongyuan
 *@create 2020-05-21 08:
 */
@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        // 添加Cors配置信息:
        CorsConfiguration config = new CorsConfiguration();
        // 1. 允许跨域，但是不要写 * 否则cookie无法使用
        config.addAllowedOrigin("http://manage.leyou.com");
        // 2.是否发送cookie 信息
        config.setAllowCredentials(true);
        // 3.允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        // 4.允许的头信息
        config.addAllowedHeader("*");
        // 有效时长
        config.setMaxAge(3600L);
        // 5.添加映射路径,我们拦截一切请求
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",config);
        // 6.返回新的CorsFilter
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
