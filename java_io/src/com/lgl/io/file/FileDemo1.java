package com.lgl.io.file;

import java.io.File;

/**
 * @author lgl
 * @Description: file类学习Demo1
 * @date 2019-08-03 16:47
 */

/**
 * file:文件
 * directory:文件夹/目录
 * path:路径
 */
public class FileDemo1 {
    public static void main(String[] args) {
        //路径分隔符 windows:分号;  Linux:冒号:
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);
        //文件名称分隔符 windows:反斜杠\ Linux:正斜杠/
        String separator = File.separator;
        System.out.println(separator);
        /**
         * 操作路径:路径不能写死
         * c:\test\a\a.txt  windows
         * c:/test/a/a.txt linux
         * 例子:
         *      "c"+File.pathSeparator+File.separator+"test"+File.separator+"a"+File.separator+"a.txt"
         */
    }
}
