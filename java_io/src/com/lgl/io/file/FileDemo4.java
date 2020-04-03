package com.lgl.io.file;

import java.io.File;

/**
 * @author lgl
 * @Description: FileDemo4
 * @date 2019-08-04 23:36
 */
public class FileDemo4 {
    public static void main(String[] args) {
        show1();
        System.out.println();
        show2();
    }

    /**
     * public boolean isDirectory():此File表示的是否为目录.
     *  用于判断构造方法中给定的路径是否以文件夹结尾
     *      是:true;
     *      否:false
     * public boolean isFile():此File表示的是否为文件.
     *  用于判断构造方法中给定的路径是否以文件结尾
     *      是:true
     *      否false
     */
    private static void show2() {
        File f1 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file/FileDemo2.java");
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        File f2 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file");
        System.out.println(f2.isDirectory());
        System.out.println(f2.isFile());
    }

    /**
     * public boolean exists():此File表示的文件或目录是否实际存在.
     * 用于判断构造方法中的路径是否存在
     * 存在:true
     * 不存在:false
     */
    private static void show1() {
        File f1 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file/FileDemo2.java");
        System.out.println(f1.exists());
        File f2 = new File("/Users/WorkSpace/java_io/src/com/lgl/io/file/FileDemoXXX.java");
        System.out.println(f2.exists());
        File f3 = new File("java_io.iml");
        System.out.println(f3.exists());
    }
}
