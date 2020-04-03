package com.leyou.upload.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.upload.service.IUploadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author lgl
 * @Description: 文件上传service接口实现类
 * @date 2020/2/3 8:53 上午
 */
@Service
@Slf4j
public class UploadServiceImpl implements IUploadService {
    private static final List<String> CONTENT_TYPES = Arrays.asList("image/gif", "image/jpeg");

    @Autowired
    private FastFileStorageClient storageClient;

    @Override
    public String uploadImage(MultipartFile file) {
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //1.校验文件类型
        String contentType = file.getContentType();
        if (!CONTENT_TYPES.contains(contentType)) {
            log.info("文件类型不合法: {}", originalFilename);
            return null;
        }
        try {
            //2.校验文件类容(防止改后缀名文件上传)
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null) {
                log.info("文件内容不合法: {}", originalFilename);
                return null;
            }
            //3.保存到服务器

            /*(-----原始写法-----)
            //文件上传的位置
            String path = "/Users/liguoliang/uploads/image/";
            //判断路径是否存在
            File filefolder = new File(path);
            if (!filefolder.exists()) {
                //创建该文件夹
                filefolder.mkdir();
            }
            String newPath = path + originalFilename;
            //保存
            file.transferTo(new File(newPath));*/

            //使用fastDFS后的写法
            String ext = StringUtils.substringAfterLast(originalFilename, ".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);
            //4.返回url,进行回显
            return "http://upload.leyou.com/" + storePath.getFullPath();
        } catch (IOException e) {
            log.info("服务器内部错误: {}", originalFilename);
            e.printStackTrace();
        }
        return null;
    }
}
