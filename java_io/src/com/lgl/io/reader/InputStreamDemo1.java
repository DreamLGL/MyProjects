package com.lgl.io.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 使用字节流读取中文文件
 * 1个中文
 *  GBK: 占用2个字节
 *  UTF-8: 占用3个字节
 * 使用字节输入流去读取就会出现乱码
 * @date 2020/3/29 1:24 上午
 */
public class InputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("c.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read()) != -1) {
            System.out.println((char) len);
        }
        fis.close();
    }
}
