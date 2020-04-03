package com.lgl.io.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 字符输出流写数据的续写和换行
 *  FileWriter(String fileName, boolean append) 构造一个FileWriter对象，给出一个带有布尔值的文件名，表示是否附加写入的数据。
 * 换行符:
 *  windows: \r\n
 *  linux: \n
 *  mac: \r
 *  \r: 回车
 *  \n: 换行
 * @date 2020/3/29 9:49 上午
 */
public class WriterDemo3 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("d.txt",true);
        fw.write("\r");
        char[] cs = {'a','b','c','d','e'};
        // - void write(char[] cbuf) 写入一个字符数组。
        fw.write(cs);

        // - void write(char[] cbuf, int off, int len) 写一个字符串的一部分
        fw.write(cs,1,3);

        // - void write(String str) 写一个字符串
        fw.write("测试字符串");

        // - void write(String str, int off, int len) 写一个字符串的一部分
        fw.write("测试字符串",1,3);
        fw.close();
    }
}
