package com.lgl.io.recurison;

import java.io.File;

/**
 * @author lgl
 * @Description: 递归打印多级目录
 * @date 2020/3/21 11:31 下午
 */
public class RecursionDemo4 {
    public static void main(String[] args) {
        String path = File.separator + "Users" + File.separator + "liguoliang" + File.separator + "Desktop" + File.separator + "test";
        File file = new File(path);
        getAllFile(file);
    }

    /**
     * 对方法中的目录进行遍历
     *
     * @param file
     */
    private static void getAllFile(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                getAllFile(file1);
            } else {
                if (file1.toString().toLowerCase().endsWith(".java")) {
                    System.out.println(file1);
                }
            }
        }
    }
}
