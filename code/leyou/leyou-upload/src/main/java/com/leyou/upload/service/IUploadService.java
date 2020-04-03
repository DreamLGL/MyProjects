package com.leyou.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author lgl
 * @Description: 文件上传service接口
 * @date 2020/2/3 8:52 上午
 */
public interface IUploadService {
    /**
     * 上传图片方法
     * @param file
     * @return
     */
    String uploadImage(MultipartFile file);
}
