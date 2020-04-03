package com.lgl.io.bufferedstream.copyfile;

/**
 * @author lgl
 * @Description: 文件copydemo
 * @date 2020/3/29 10:28 下午
 */
public class CopyFileDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new CopyFileImpl("copy","copyRes.txt"));
        Thread t2 = new Thread(new CopyFileImpl("bufferedCopy","copyRes.txt"));
        t1.start();
        t2.start();
    }
}
