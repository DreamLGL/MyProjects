package com.lgl.io.file;

import java.io.File;

/**
 * @author lgl
 * @Description: FileDemo3
 * @date 2019-08-04 23:11
 */
public class FileDemo3 {
    public static void main(String[] args) {
        show01();
        show02();
        show03();
        show04();
    }

    /**
     * public String length():返回由此File表示的文件的长度.
     * 获取的是构造方法指定的文件的大小,一字节为单位
     *  注意:
     *      文件夹是没有大小概念的,不能获取文件夹的大小
     *      如果构造方法中给出的路径不存在,那么length方法返回0
     */
    private static void show04() {
        File f1 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file/FileDemo2.java");
        long size1 = f1.length();
        System.out.println(size1);
        File f2 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file/.txt");
        long size2 = f2.length();
        System.out.println(size2);
        File f3 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file");
        long size3 = f2.length();
        System.out.println(size3);
    }

    /**
     * public String getName():返回由此File表示的文件或目录名称.
     */
    private static void show03() {
        File f1 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file/FileDemo2.java");
        String name1 = f1.getName();
        System.out.println(name1);
        File f2 = new File("src/com/lgl/io/file");
        String name2 = f2.getName();
        System.out.println(name2);
    }

    /**
     * public String getPath():将此File转换为路径名字符串.
     * 获取构造方法中传递的路径
     */
    private static void show02() {
        File f1 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file/FileDemo2.java");
        File f2 = new File("src/com/lgl/io/file/FileDemo2.java");
        String path1 = f1.getPath();
        System.out.println(path1);
        String path2 = f2.getPath();
        System.out.println(path2);

        System.out.println(f1);
        System.out.println(f1.toString());
    }

    /**
     * public String getAbsolutePath():返回File的绝对路径名字符串.
     * 获取的构造方法中传递的路径
     * 无论路径是绝对的还是相对的,getAbsolutePath()方法返回的都是绝对路径.
     */
    private static void show01() {
        File f1 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file/FileDemo2.java");
        String absolutePath1 = f1.getAbsolutePath();
        System.out.println(absolutePath1);

        File f2 = new File("src/com/lgl/io/file/FileDemo2.java");
        String absolutePath2 = f2.getAbsolutePath();
        System.out.println(absolutePath2);
    }
}
