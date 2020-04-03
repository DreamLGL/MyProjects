package com.lgl.therad.multithread;

/**
 * @author lgl
 * @Description: 创建一个Thread子类
 * @date 2020/3/14 3:47 下午
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run:" + i);
        }
    }
}
