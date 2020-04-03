package com.lgl.io.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 字符输入流
 * java.io.Reader: 字符输入流,是字符输入流最顶层的父类,定义了一些共性的成员方法,是一个抽象类
 * 共性的成员方法:
 *  -read() 读一个字符
 *  -read(char[] cbuf) 将字符读入数组。
 *  -void close() 关闭流并释放与之相关联的任何系统资源。
 * java.io.FileReader extends InputStreamReader extends Reader
 * FileReader: 文件字符输入流
 * 作用: 把硬盘文件中的数据以字符的方式读取到内存中
 *
 * 构造方法:
 * FileReader(File file) 创建一个新的 FileReader ，给出 File读取。
 * FileReader(String fileName) 创建一个新的 FileReader ，给定要读取的文件的名称。
 * @date 2020/3/29 1:32 上午
 */
public class ReaderDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("c.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        /*
        // 读取单个字符
        int len = 0;
        while ((len = fr.read())!=-1){
            System.out.println((char) len);
        }*/

        char[] cs = new char[1024];
        int len = 0;
        while ((len = br.read(cs))!=-1){
            String s = new String(cs, 0, len);
            System.out.print(s);
        }
       /* int line = 1;
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println("line: "+line+": "+str);
            line++;
        }*/
        fr.close();
    }
}
