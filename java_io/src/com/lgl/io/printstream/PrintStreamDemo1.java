package com.lgl.io.printstream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author lgl
 * @Description: 打印流
 * java.io.PrintStream: 打印流
 *      PrintStream: 为其他输出流添加了功能,使它们能够方便的打印各种数据值表示形式.
 * PrintStream特点:
 *      1. 只负责数据的输出,不负责数据的读取
 *      2. 与其他输出流不同,PrintStream永远不会抛出IOException
 *      3. 有特有的方法
 *          void print(任意类型的值)
 *          void println(任意类型的值并换行)
 * 构造方法:
 *      PrintStream​(File file) 使用指定的文件创建没有自动行刷新的新打印流。输出的目的地是一个文件
 *      PrintStream​(OutputStream out) 创建新的打印流. 输出的目的地是一个字节输出流
 *      PrintStream​(String fileName) 使用指定的文件名创建没有自动行刷新的新打印流。 输出的目的地是一个文件路径
 *
 * PrintStream extends FilterOutputStream implements Appendable, Closeable
 * 继承自父类的成员方法:
 *     - void close() 关闭此输出流并释放与此流相关联的任何系统资源。
 *     - void flush() 刷新此输出流并强制任何缓冲的输出字节被写出。
 *     - void write(byte[] b) 将 b.length字节从指定的字节数组写入此输出流。
 *     - void write(byte[] b, int off, int len) 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流。
 *     - abstract void write(int b) 将指定的字节写入此输出流。
 * @date 2020/3/30 4:29 下午
 */
public class PrintStreamDemo1 {
    public static void main(String[] args) {
        try (PrintStream ps=new PrintStream("print.txt")){
            ps.write(97);
            ps.print(97);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
