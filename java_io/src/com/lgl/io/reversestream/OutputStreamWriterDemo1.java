package com.lgl.io.reversestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author lgl
 * @Description: 转化输出流
 * java.io.OutputStreamWriter extends Writer
 * OutputStreamWriter: 是字符流通向字节流的桥梁: 可使用指定的charset将要写入流中的字符编码成字节.(编码:把能看懂的变成看不懂的)
 * 继承自父类的共性成员方法:
 *    - void write(int c) 写一个字符
 *    - void write(char[] cbuf) 写入一个字符数组。
 *    - abstract void write(char[] cbuf, int off, int len) 写入字符数组的一部分。
 *    - void write(String str) 写一个字符串
 *    - void write(String str, int off, int len) 写一个字符串的一部分
 *    - abstract void	flush() 刷新流。
 *    - abstract void	close() 关闭流，先刷新。
 * 构造方法:
 *    OutputStreamWriter(OutputStream out) 创建一个使用默认字符编码的OutputStreamWriter。
 *    OutputStreamWriter(OutputStream out, String charsetName) 创建一个使用命名字符集的OutputStreamWriter。
 * @date 2020/3/29 11:52 下午
 */
public class OutputStreamWriterDemo1 {
    public static void main(String[] args) {
        writeUTF8();
        writeGBK();
    }

    /**
     * 使用转换流OutputStreamWriter写GBK格式的文件
     */
    private static void writeGBK() {
        try(OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("gbk.txt"),"gbk");){
            osw.write("你好");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用转换流OutputStreamWriter写utf-8格式的文件
     */
    private static void writeUTF8() {
        try(OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("utf_8.txt"));){
            osw.write("你好");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
