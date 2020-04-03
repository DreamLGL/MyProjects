package com.lgl.io.bufferedstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 字符缓冲输入流
 * 继承自父类的共性成员方法:
 *   -read() 读一个字符
 *   -read(char[] cbuf) 将字符读入数组。
 *   -void close() 关闭流并释放与之相关联的任何系统资源
 * 构造方法:
 *  BufferedReader(Reader in) 创建使用默认大小的输入缓冲区的缓冲字符输入流。
 *  BufferedReader(Reader in, int sz) 创建使用指定大小的输入缓冲区的缓冲字符输入流。
 * 特有的成员方法:
 *  int	read(char[] cbuf, int off, int len) 将字符读入数组的一部分
 * @date 2020/3/29 11:05 下午
 */
public class BufferedReaderDemo1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("g.txt"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
