package com.lgl.io.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author lgl
 * @Description:
 *  InputStream: 字节输入流
 *  这个抽象类是表示输入字节流的所有类的超类。
 *
 *  定义了所有子类共性的方法:
 *      int	read() 从输入流读取数据的下一个字节。
 *      int	read(byte[] b) 从输入流读取一些字节数，并将它们存储到缓冲区 b。
 *      void close() 关闭此输入流并释放与流相关联的任何系统资源。
 *
 *  java.io.FileInputStream extends InputStream
 *  FileOutputStream: 文件字节输入流
 *  作用: 把硬盘文件中的数据,读取到内存中使用
 *
 *  构造方法:
 *      FileInputStream(File file) 通过打开与实际文件的连接创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。
 *      FileInputStream(FileDescriptor fdObj) 创建 FileInputStream通过使用文件描述符 fdObj ，其表示在文件系统中的现有连接到一个实际的文件。
 *      FileInputStream(String name) 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。
 *
 *  读取数据的原理:
 *      Java程序-->JVM-->OS-->OS读取数据的方法-->读取文件
 *
 *
 * @date 2020/3/24 11:29 下午
 */
public class InputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        /*int len = fis.read();
        System.out.println(len);
        int len2 = fis.read();
        System.out.println(len2);
        int len3 = fis.read();
        System.out.println(len3);
        int len4 = fis.read();
        System.out.println(len4);*/
        int len = 0;
        while ((len=fis.read()) != -1) {
            System.out.println((char) len);
        }
        fis.close();

    }
}
