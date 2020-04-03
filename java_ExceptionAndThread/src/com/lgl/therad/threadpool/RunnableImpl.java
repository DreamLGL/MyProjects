package com.lgl.therad.threadpool;

/**
 * @author lgl
 * @Description: 2.创建一个类, 实现Runnable接口, 重写run方法.设置线程任务
 * @date 2020/3/15 5:36 下午
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");
    }
}
