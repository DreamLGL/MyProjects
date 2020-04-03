package com.lgl.io.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 字符输出流
 * java.io.Writer: 字符输出流,是所有字符输出流的最顶层父类,是一个抽象类
 *
 * 共性的成员方法:
 *  - void write(int c) 写一个字符
 * 	- void write(char[] cbuf) 写入一个字符数组。
 *  - abstract void write(char[] cbuf, int off, int len) 写入字符数组的一部分。
 *  - void write(String str) 写一个字符串
 *  - void write(String str, int off, int len) 写一个字符串的一部分
 *  - abstract void	flush() 刷新流。
 *  - abstract void	close() 关闭流，先刷新。
 *
 * java.io.FileWriter extends OutputStreamWriter extends Writer
 * FileWriter: 文件字符输出流
 * 作用:吧内存中的字符数据写入到文件中
 *
 * 构造方法:
 *  FileWriter(File file) 给一个File对象构造一个FileWriter对象。
 *  FileWriter(String fileName) 构造一个给定文件名的FileWriter对象
 *
 * @date 2020/3/29 1:59 上午
 */
public class WriterDemo1 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("d.txt");
        fw.write(97);
        fw.flush();
        fw.close();
    }
}
