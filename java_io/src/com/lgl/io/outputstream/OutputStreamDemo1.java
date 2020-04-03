package com.lgl.io.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author lgl
 * @Description: 字节输出流, 最顶层父类
 *  java.io.OutputStream
 *  定义的方法:
 *    - void close() 关闭此输出流并释放与此流相关联的任何系统资源。
 *    - void flush() 刷新此输出流并强制任何缓冲的输出字节被写出。
 *    - void write(byte[] b) 将 b.length字节从指定的字节数组写入此输出流。
 *    - void write(byte[] b, int off, int len) 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流。
 *    - abstract void write(int b) 将指定的字节写入此输出流。
 * java.io.FileOutputStream extends OutputStream
 * FilterOutputStream: 文件字节输出流
 * 作用:把内存中的数据写入到硬盘中
 * 构造方法:
 *  - FileOutputStream(File file) 创建文件输出流以写入由指定的 File对象表示的文件。
 *  - FileOutputStream(File file, boolean append) 创建文件输出流以写入由指定的 File对象表示的文件。
 *  - FileOutputStream(FileDescriptor fdObj) 创建文件输出流以写入指定的文件描述符，表示与文件系统中实际文件的现有连接。
 *  - FileOutputStream(String name) 创建文件输出流以指定的名称写入文件。
 *  - FileOutputStream(String name, boolean append) 创建文件输出流以指定的名称写入文件。
 * 写入流程:
 *  Java程序->JVM->OS->OS调用写数据的方法->把数据写入文件中
 * 字节输出流的使用步骤(重点):
 *  1.FileOutputStream对象,构造方法中传递写入数据的目的地
 *  2.调用FileOutputStream对象中的方法write,把数据写入到文件中
 *  3.释放资源(流使用会占用一定的内存,使用完毕要把内存清空,提高程序的效率)
 * @date 2020/3/23 3:34 下午
 */
public class OutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("a.txt");
        fos.write(97);
        fos.close();
    }
}
