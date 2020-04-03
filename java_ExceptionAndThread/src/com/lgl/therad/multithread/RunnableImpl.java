package com.lgl.therad.multithread;

/**
 * @author lgl
 * @Description: Runnable接口实现类
 * @date 2020/3/14 4:25 下午
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
