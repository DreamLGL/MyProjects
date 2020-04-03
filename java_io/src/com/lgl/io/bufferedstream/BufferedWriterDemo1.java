package com.lgl.io.bufferedstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 字符缓冲输出流
 *  继承父类的共性成员方法:
 *      - void write(int c) 写一个字符
 *      - void write(char[] cbuf) 写入一个字符数组。
 *      - abstract void write(char[] cbuf, int off, int len) 写入字符数组的一部分。
 *      - void write(String str) 写一个字符串
 *      - void write(String str, int off, int len) 写一个字符串的一部分
 *      - abstract void	flush() 刷新流。
 *      - abstract void	close() 关闭流，先刷新。
 *
 *  构造方法:
 *      BufferedWriter(Writer out) 创建使用默认大小的输出缓冲区的缓冲字符输出流。
 *      BufferedWriter(Writer out, int sz) 创建一个新的缓冲字符输出流，使用给定大小的输出缓冲区。
 *
 *  特有的成员方法:
 *      void newLine()写一行行分隔符。
 *
 * @date 2020/3/29 11:04 下午
 */
public class BufferedWriterDemo1 {
    public static void main(String[] args) {
        try (BufferedWriter bwr=new BufferedWriter(new FileWriter("g.txt"))){
            for (int i = 0; i < 100; i++) {
                bwr.write("BufferedWriter"+i);
                bwr.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
