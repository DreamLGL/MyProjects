package com.lgl.lambda;

/**
 * @author lgl
 * @Description: 创建Runnable接口的实现类, 重写run方法, 设置线程任务
 * @date 2020/3/15 5:46 下午
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
