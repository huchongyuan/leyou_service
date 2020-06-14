package com.leyou.upload.web;/*
 *@params com.leyou.upload.web
 *@description 上传控制器
 *@auth huchongyuan
 *@create 2020-05-21 14:
 */
import com.leyou.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;
    /*
    * post 上传文件
    * @param file
    * return 文件上传成功后的文件地址
    * */
    @PostMapping("/postImage")
    public ResponseEntity<String> postImage(@RequestParam("file") MultipartFile file){
        return ResponseEntity.ok(uploadService.uploadImage(file));
    }
}
