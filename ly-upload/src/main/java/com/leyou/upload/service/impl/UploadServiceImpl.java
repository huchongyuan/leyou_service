package com.leyou.upload.service.impl;
/*
 *@params com.leyou.upload.service.impl
 *@description
 *@auth huchongyuan
 *@create 2020-05-21 14:
 */

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.enums.ExceptionEnum;
import com.leyou.exception.LyException;
import com.leyou.upload.config.UploadProperties;
import com.leyou.upload.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@Service
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadProperties uploadProperties;
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private ThumbImageConfig thumbImageConfig;
    @Override
    public String uploadImage(MultipartFile file) {
        try {
            // 校验文件类型
            String contentType = file.getContentType();
            if(!uploadProperties.getAllowTypes().contains(contentType)){
                throw new LyException(ExceptionEnum.FILE_TYPE_NOT_ALLOW);
            }
            // 校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(null == image){
                throw new LyException(ExceptionEnum.FILE_TYPE_NOT_ALLOW);
            }
            // 获取后缀名
            //String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')+1);
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            // FastDFS 上传文件;
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            // 2.返回路径;
            return uploadProperties.getBaseUrl() + storePath.getFullPath();
        } catch (Exception e) {
            // 上传失败,记录日志
            log.error("上传文件失败！", e);
            throw new LyException(ExceptionEnum.FILE_UPLOAD_ERROR);
        }
    }
}
