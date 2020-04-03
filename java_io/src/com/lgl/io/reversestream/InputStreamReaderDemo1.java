package com.lgl.io.reversestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lgl
 * @Description: 转化输入流
 * java.io.InputStreamReader extends Reader
 * InputStreamReader: 是从字节流到字符流的桥梁: 它使用指定的charset读取字节并将其解码为字符.(解码:把看不懂的变成能看懂的)
 * 继承的父类的共性成员方法:
 *     -read() 读一个字符
 *     -read(char[] cbuf) 将字符读入数组。
 *     -void close() 关闭流并释放与之相关联的任何系统资源
 * 构造方法:
 *     InputStreamReader​(InputStream in) 创建一个使用默认字符集的InputStreamReader。
 *     InputStreamReader​(InputStream in, String charsetName) 创建一个使用指定charset的InputStreamReader。
 *
 * @date 2020/3/30 12:06 上午
 */
public class InputStreamReaderDemo1 {
    public static void main(String[] args) {
        readUTF8();
        readGBK();
    }

    /**
     * 读取GBK
     */
    private static void readGBK() {
        try (InputStreamReader isr=new InputStreamReader(new FileInputStream("GBK.txt"),"GBK")){
            char[] chars = new char[1024];
            int len = 0;
            while ((len=isr.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 读取UTF-8文件
     */
    private static void readUTF8() {
        try (InputStreamReader isr=new InputStreamReader(new FileInputStream("utf_8.txt"))){
            char[] chars = new char[1024];
            int len = 0;
            while ((len=isr.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
