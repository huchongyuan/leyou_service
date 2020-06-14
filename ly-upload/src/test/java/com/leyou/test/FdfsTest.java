package com.leyou.test;/*
 *@params com.leyou.test
 *@description Fdfs 上传测试类
 *@auth huchongyuan
 *@create 2020-05-31 10:
 */

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FdfsTest {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("J:\\2018041015541653038.jpg");
        StorePath storagePath = this.fastFileStorageClient.uploadFile(new FileInputStream(file), file.length(), "jpg", null);
        // 带分组的路径
        System.out.println(storagePath.getFullPath());
        // 不带分组的路径
        System.out.println(storagePath.getPath());
    }
    @Test
    public void testThumbUpload() throws FileNotFoundException{
        File file = new File("J:\\2018041015541653038.jpg");
        StorePath storagePath = this.fastFileStorageClient.uploadImageAndCrtThumbImage(new FileInputStream(file), file.length(), "jpg", null);
        // 带分组的路径
        System.out.println(storagePath.getFullPath());
        // 不带分组的路径
        System.out.println(storagePath.getPath());

        // 获取缩略图的路径
        String thumbImagePath = thumbImageConfig.getThumbImagePath(storagePath.getPath());
        System.out.println(thumbImagePath);
    }
}
