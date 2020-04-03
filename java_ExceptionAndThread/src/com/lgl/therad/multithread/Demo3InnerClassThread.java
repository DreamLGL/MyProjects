package com.lgl.therad.multithread;

/**
 * @author lgl
 * @Description: 匿名内部类方式创建多线程
 * @date 2020/3/14 4:31 下午
 */
public class Demo3InnerClassThread {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->" + i);
                }
            }
        }.start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->" + i);
                }
            }
        };
        new Thread(runnable).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->" + i);
                }
            }
        }).start();
    }
}
