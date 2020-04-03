package com.lgl.io.file;

import java.io.File;

/**
 * @author lgl
 * @Description: FileDemo6
 * @date 2019-08-05 23:16
 */
public class FileDemo6 {
    public static void main(String[] args) {
        show01();
        show02();
    }

    /**
     * public File[] listFile():返回File数组,表示File目录中所有的子文件或目录
     */
    private static void show02() {
        File f1 = new File("/Users/WorkSpace/java_io");
        File[] arr = f1.listFiles();
        System.out.println(arr);
        for (File fileName : arr) {
            System.out.println(fileName);
        }
    }

    /**
     * public String[] list():返回一个String数组,表示File目录中所有的子文件或目录.
     */
    private static void show01() {
        File f1 = new File("/Users/WorkSpace/java_io");
        String[] arr = f1.list();
        System.out.println(arr);
        for (String fileName : arr) {
            System.out.println(fileName);
        }
    }
}
