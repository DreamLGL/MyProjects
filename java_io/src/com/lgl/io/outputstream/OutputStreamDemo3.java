package com.lgl.io.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lgl
 * @Description:
 *  追加写/续写Demo
 *      FileOutputStream(File file, boolean append) 创建文件输出流以写入由指定的 File对象表示的文件。
 *      FileOutputStream(String name, boolean append) 创建文件输出流以指定的名称写入文件
 *  换行:
 *      windows: \r\n
 *      linux: /n
 *      mac: \r
 * @date 2020/3/24 10:59 下午
 */
public class OutputStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("c.txt",true);
        fos.write("追加测试".getBytes());
        for (int i = 0; i < 10; i++) {
            fos.write("你好".getBytes());
            fos.write("\r".getBytes());
        }
        fos.close();
    }
}
