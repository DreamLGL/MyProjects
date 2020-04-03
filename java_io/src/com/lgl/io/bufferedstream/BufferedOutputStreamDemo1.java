package com.lgl.io.bufferedstream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 字节缓冲输出流
 * java.io.BufferedOutputStream extends FilterOutputStream
 * BufferedOutputStream: 字节缓冲输出流
 *
 * 继承自父类的共性成员方法:
 *    - void close() 关闭此输出流并释放与此流相关联的任何系统资源。
 *    - void flush() 刷新此输出流并强制任何缓冲的输出字节被写出。
 *    - void write(byte[] b) 将 b.length字节从指定的字节数组写入此输出流。
 *    - void write(byte[] b, int off, int len) 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流。
 *    - abstract void write(int b) 将指定的字节写入此输出流。
 *
 * 构造方法:
 *    BufferedOutputStream(OutputStream out) 创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
 *    BufferedOutputStream(OutputStream out, int size) 创建一个新的缓冲输出流，以便以指定的缓冲区大小将数据写入指定的底层输出流。
 * @date 2020/3/29 10:05 下午
 */
public class BufferedOutputStreamDemo1 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("f.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos);) {
            bos.write("我把数据写入到内部缓冲区中".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
