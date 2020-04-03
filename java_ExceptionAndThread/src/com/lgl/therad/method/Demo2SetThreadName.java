package com.lgl.therad.method;

/**
 * @author lgl
 * @Description: 获取线程名称方法
 * @date 2020/3/14 4:01 下午
 */
public class Demo2SetThreadName {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2("test1");
        myThread.start();
        new MyThread2("test2").start();
        new MyThread2("test3").start();
        new MyThread2("test4").start();
    }
}
