package com.lgl.io.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 一次写多个字节
 * - void write(byte[] b) 将 b.length个字节从指定的字节数组写入此文件输出流。
 * - void write(byte[] b, int off, int len) 将 len字节从位于偏移量 off的指定字节数组写入此文件输出流。
 * @date 2020/3/23 3:59 下午
 */
public class OutputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("b.txt");
        fos.write(49);
        fos.write(48);
        fos.write(48);
        /*
        - void write(byte[] b) 将 b.length个字节从指定的字节数组写入此文件输出流
         */
        byte[] bytes = {65, 66, 67, 68, 69};
        fos.write(bytes);
        /*
        - void write(byte[] b, int off, int len) 将 len字节从位于偏移量 off的指定字节数组写入此文件输出流。
         */
        fos.write(bytes, 1, 2);
        /*
        写入字符串的方法:可以使用String类中的方法吧字符串转换为字节数组
         */
        byte[] bytes1 = "你好".getBytes();
        fos.write(bytes1);
        fos.close();
    }
}
