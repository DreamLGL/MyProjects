package com.lgl.io.inputstream;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * @author lgl
 * @Description:
 *  一次读取多个字节的方法:
 *      int	read(byte[] b) 从输入流读取一些字节数，并将它们存储到缓冲区 b。
 * @date 2020/3/25 12:07 上午
 */
public class InputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("b.txt");
        byte[] bytes = new byte[1024];
        /*int len = fis.read(bytes);
        System.out.println(len);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes,0,len));*/
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fis.close();
    }
}
