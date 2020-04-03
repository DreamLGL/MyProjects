package com.lgl.io.exception;

import java.io.*;

/**
 * @author lgl
 * @Description: 处理IO异常
 * JDK7的新特性:
 * 在try的后边可以增加一个(),在括号中可以定义流对象,那么这个流对象的作用域就在try中有效,
 * try中的代码执行完毕,会自动把流对象释放,不用写finally
 * 格式:
 *  try(定义流对象;定义流对象...){
 *      可能产生异常的代码
 *  }catch(异常类变量 变量名){
 *      异常的处理逻辑
 *  }
 * @date 2020/3/29 4:00 下午
 */
public class TryCatchDemo2 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("d.txt");
             FileOutputStream fos = new FileOutputStream("e.txt");) {
            int len = 0;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
