package com.lgl.therad.status.waitandnotify;

/**
 * @author lgl
 * @Description: 进入到TimeWaiting(计时等待)有两种方式
 * 1.使用sleep(long m)方法,在毫秒值结束之后,线程睡醒进入到Runnable/Blocked状态
 * 2.使用wait(long m)方法,wait方法如果在毫秒值结束之后,还没有被notify唤醒,就会自动醒来,
 * 唤醒方法
 * notify() 唤醒在此对象监视器上等待的单个线程.
 * notifyAll() 唤醒在此对象监视器上等待的所有线程.
 * @date 2020/3/15 3:36 下午
 */
public class WaitAndNotifyDemo2 {
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
                        System.out.println("顾客1: 告知老板要的包子的种类和数量");
                        // 调用wait方法,放弃cpu的执行,进入到waiting状态(无限等待)
                        try {
                            object.wait(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // 唤醒之后的代码
                        System.out.println("顾客1: 包子做好了,开吃");
                        System.out.println("----------------------------------------------------------");
                    }
                }
            }
        }.start();
        // 创建一个顾客线程(消费者)
        new Thread() {
            @Override
            public void run() {
                // 一直等个买包子
                while (true) {
                    // 保证等待和唤醒只能有一个在执行,需要使用同步技术
                    synchronized (object) {
                        System.out.println("顾客2: 告知老板要的包子的种类和数量");
                        // 调用wait方法,放弃cpu的执行,进入到waiting状态(无限等待)
                        try {
                            object.wait(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // 唤醒之后的代码
                        System.out.println("顾客2: 包子做好了,开吃");
                        System.out.println("----------------------------------------------------------");
                    }
                }
            }
        }.start();
        // 创建一个顾客线程(消费者)
        new Thread() {
            @Override
            public void run() {
                // 一直等个买包子
                while (true) {
                    // 保证等待和唤醒只能有一个在执行,需要使用同步技术
                    synchronized (object) {
                        System.out.println("顾客3: 告知老板要的包子的种类和数量");
                        // 调用wait方法,放弃cpu的执行,进入到waiting状态(无限等待)
                        try {
                            object.wait(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // 唤醒之后的代码
                        System.out.println("顾客3: 包子做好了,开吃");
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
//                        object.notify();
                        object.notifyAll();
                    }
                }
            }
        }.start();
    }
}
