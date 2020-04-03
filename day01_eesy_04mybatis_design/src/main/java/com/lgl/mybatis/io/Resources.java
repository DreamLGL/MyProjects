package com.lgl.mybatis.io;

import java.io.InputStream;

/**
 * @author lgl
 * @Description: 使用类加载器读取配置文件的类
 * @date 2019/11/4 10:59 下午
 */
public class Resources {
    /**
     * 根据传入的参数,获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
