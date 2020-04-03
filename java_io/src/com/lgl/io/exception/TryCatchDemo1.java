package com.lgl.io.exception;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lgl
 * @Description: 处理IO异常
 * @date 2020/3/29 4:00 下午
 */
public class TryCatchDemo1 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("d.txt", true);
            for (int i = 0; i < 10; i++) {
                fw.write("测试字符串");
                fw.write("\r");
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
