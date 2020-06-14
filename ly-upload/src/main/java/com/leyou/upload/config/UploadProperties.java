package com.leyou.upload.config;/*
 *@params com.leyou.upload.config
 *@description 文件上传属性
 *@auth huchongyuan
 *@create 2020-05-31 11:
 */
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "ly.upload")
public class UploadProperties {
    private String baseUrl;
    private List<String> allowTypes;

}
