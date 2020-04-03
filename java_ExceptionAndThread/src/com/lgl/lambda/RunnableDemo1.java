package com.lgl.lambda;

/**
 * @author lgl
 * @Description: 使用实现Runnable接口方式实现多线程程序
 * @date 2020/3/15 5:45 下午
 */
public class RunnableDemo1 {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        new Thread(runnable).start();

        //简化代码
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        new Thread(r).start();

        //继续简化
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
