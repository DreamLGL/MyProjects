package com.lgl.io.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * @author lgl
 * @Description: 文件过滤器
 * @date 2020/3/21 11:44 下午
 */
public class IoFilterDemo1 {
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
//        File[] files = file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                if (pathname.toString().toLowerCase().endsWith(".java") || pathname.isDirectory()) {
//                    return true;
//                }
//                return false;
//            }
//        });

        //lambda表达式简化上面的方法
        File[] files = file.listFiles(pathname -> pathname.toString().toLowerCase().endsWith(".java") || pathname.isDirectory());
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
