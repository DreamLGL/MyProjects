package com.lgl.therad.method;

/**
 * @author lgl
 * @Description: 获取线程名称:
 * 1. 使用Thread类中的方法getName() 返回线程的名称
 * 2. 可以现获取到当前正在执行的线程,使用线程中的方法getName()获取线程的名称
 * @date 2020/3/14 3:47 下午
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
//        String name = getName();
//        System.out.println("线程名称:" + name);
        System.out.println("线程名称:" + Thread.currentThread().getName());
    }
}
