package com.lgl.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @author lgl
 * @Description: FileDemo5
 * @date 2019-08-05 22:51
 */
public class FileDemo5 {
    public static void main(String[] args) throws IOException {
//        show01();
        show02();
    }

    /**
     * public boolean mkdir():创建单级空文件夹
     * public boolean mkdirs():即可穿件单级空文件夹,也介意创建多级文件夹
     */
    private static void show02() {
        File f1 = new File("a");
        System.out.println(f1.mkdirs());

        File f2 = new File("a/b/c/d");
        System.out.println(f2.mkdirs());
    }

    /**
     * public boolean createNewFile();当且仅当具有该名称的文件尚不存在时,创建一个新的空文件.
     * 创建文件的路径和名称在构造方法中给出(构造方法的参数)
     * 返回值:布尔值
     *  true:文件不存在,创建文件,返回true
     *  false:文件存在,不会创建,返回false
     * 注意:
     *  1.此方法只能创建文件,不能创建文件夹
     *  2.创建文件的路径不许存在,否则会抛出异常
     */
    private static void show01() throws IOException {
        File f1 = new File("/Users/WorkSpace/java_io/src/a.txt");
        boolean b1 = f1.createNewFile();
        System.out.println("b1 : "+b1);

        File f2 = new File("a.txt");
        boolean b2 = f2.createNewFile();
        System.out.println("b2 : "+b2);

        File f3 = new File("新建文件");//不要被名称迷惑,要看类型
        boolean b3 = f3.createNewFile();
        System.out.println("b3 : "+b3);
    }
}
