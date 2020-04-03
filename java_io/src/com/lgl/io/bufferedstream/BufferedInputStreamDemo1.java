package com.lgl.io.bufferedstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 字节缓冲输入流
 * 继承父类的成员方法:
 *    int read() 从输入流读取数据的下一个字节。
 *    int read(byte[] b) 从输入流读取一些字节数，并将它们存储到缓冲区 b。
 *    void close() 关闭此输入流并释放与流相关联的任何系统资源。
 * 构造方法:
 *    BufferedInputStream(InputStream in) 创建一个 BufferedInputStream并保存其参数，输入流 in ，供以后使用。
 *    BufferedInputStream(InputStream in, int size) 创建 BufferedInputStream具有指定缓冲区大小，并保存其参数，输入流 in ，供以后使用。
 * @date 2020/3/29 10:17 下午
 */
public class BufferedInputStreamDemo1 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("f.txt");
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
