package com.lgl.io.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lgl
 * @Description: flush()和close()方法的区别
 *  - flush: 刷新缓冲区,流对象可以继续使用
 *  - close: 先刷新缓冲区,然后通知系统释放资源,流对象不可以再被使用了.
 * @date 2020/3/29 9:41 上午
 */
public class CloseAndFlushDemo1 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("d.txt");
        fw.write(97);
        fw.flush();
        // 刷新之后流可以继续使用
        fw.write(98);
        fw.close();
        // close之后,流已经关闭了,已经从内存中消失了,流不能在使用了
//        fw.write(99); // java.io.IOException: Stream closed
    }
}
