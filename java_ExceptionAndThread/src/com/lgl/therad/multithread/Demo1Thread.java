package com.lgl.therad.multithread;

/**
 * @author lgl
 * @Description: 创建多线程的第一种方式:创建Thread类的子类
 * @date 2020/3/14 3:44 下午
 */
public class Demo1Thread {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("main:" + i);
        }
    }
}
