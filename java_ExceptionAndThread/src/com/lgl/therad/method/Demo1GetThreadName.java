package com.lgl.therad.method;

/**
 * @author lgl
 * @Description: 获取线程名称方法
 * @date 2020/3/14 4:01 下午
 */
public class Demo1GetThreadName {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        new MyThread1().start();
        new MyThread1().start();
        new MyThread1().start();
        System.out.println("线程名称:" + Thread.currentThread().getName());
    }
}
