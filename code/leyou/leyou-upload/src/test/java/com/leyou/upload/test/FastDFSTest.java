package com.leyou.upload.test;

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

/**
 * @author lgl
 * @Description: fastDFS测试
 * @date 2020/2/4 11:01 上午
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FastDFSTest {
    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    /**
     * 上传文件
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testUpload() throws FileNotFoundException {
        // 要上传的文件
        File file = new File("/Users/liguoliang/uploads/image/f40a5a7095ed4060b513ad28df12b35f_girl8.jpg");
        // 上传并保存图片，参数：1-上传的文件流 2-文件的大小 3-文件的后缀 4-可以不管他
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "jpg", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
    }

    /**
     * 上传图片并生成缩略图
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testUploadAndCreateThumb() throws FileNotFoundException {
        File file = new File("/Users/liguoliang/uploads/image/f40a5a7095ed4060b513ad28df12b35f_girl8.jpg");
        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(
                new FileInputStream(file), file.length(), "png", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
        // 获取缩略图路径
        String path = thumbImageConfig.getThumbImagePath(storePath.getPath());
        System.out.println(path);
    }
}
