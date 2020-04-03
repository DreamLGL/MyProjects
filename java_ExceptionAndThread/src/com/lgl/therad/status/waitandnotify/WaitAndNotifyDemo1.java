package com.lgl.therad.status.waitandnotify;

/**
 * @author lgl
 * @Description: 等待唤醒案例: 线程之间的通信
 * 创建一个顾客线程(消费者): 告知老板要的包子的种类和数量,调用wait方法,放弃cpu执行,进入到waiting状态(无限等待)
 * 创建一个老板线程(生产者): 花了5秒做包子,做好包子之后,调用notify方法,唤醒顾客吃包子
 * 注意:
 * 顾客和老板线程必须使用同步代码块包裹起来,保证等待和唤醒只能有一个在执行
 * 同步使用的锁对象必须保证唯一
 * 只有锁对象才能调用wait和notify方法
 * @date 2020/3/15 3:36 下午
 */
public class WaitAndNotifyDemo1 {
    public static void main(String[] args) {
        // 创建锁对象,保证唯一
        Object object = new Object();
        // 创建一个顾客线程(消费者)
        new Thread() {
            @Override
            public void run() {
                // 一直等个买包子
                while (true) {
                    // 保证等待和唤醒只能有一个在执行,需要使用同步技术
                    synchronized (object) {
                        System.out.println("顾客: 告知老板要的包子的种类和数量");
                        // 调用wait方法,放弃cpu的执行,进入到waiting状态(无限等待)
                        try {
                            object.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // 唤醒之后的代码
                        System.out.println("顾客: 包子做好了,开吃");
                        System.out.println("----------------------------------------------------------");
                    }
                }
            }
        }.start();

        // 创建一个老板线程(生产者)
        new Thread() {
            @Override
            public void run() {
                // 一直在做包子
                while (true) {
                    //花了5秒做包子
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 保证等待和唤醒只能有一个在执行,需要使用同步技术
                    synchronized (object) {
                        System.out.println("老板: 老板5秒钟之后做好包子,告知顾客,可以吃包子了");
                        // 做好包子之后,调用notify方法,唤醒顾客吃包子
                        object.notify();
                    }
                }
            }
        }.start();
    }
}
