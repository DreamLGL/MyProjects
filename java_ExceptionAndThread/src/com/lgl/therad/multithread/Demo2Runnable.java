package com.lgl.therad.multithread;

/**
 * @author lgl
 * @Description: 创建多线程的第二种方法Runnable
 * @date 2020/3/14 4:23 下午
 */
public class Demo2Runnable {
    public static void main(String[] args) {
        RunnableImpl run = new RunnableImpl();
        Thread r = new Thread(run);
        r.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
