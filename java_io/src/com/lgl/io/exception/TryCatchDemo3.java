package com.lgl.io.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 处理IO异常
 * JDK9的新特性:
 * try的前边可以定义流对象
 * 在try后边()中可以直接引入流对象的名称(变量名)
 * 在try代码执行完毕之后,流对象也可以释放掉,不用写finally
 * 格式:
 *  A a = new A()
 *  B b = new B()
 *  try(a,b){
 *      可能产生异常的代码
 *  }catch(异常类变量 变量名){
 *      异常的处理逻辑
 *  }
 * @date 2020/3/29 4:00 下午
 */
public class TryCatchDemo3 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("d.txt");
        FileOutputStream fos = new FileOutputStream("e.txt");
        try (fis;fos) {
            int len = 0;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
