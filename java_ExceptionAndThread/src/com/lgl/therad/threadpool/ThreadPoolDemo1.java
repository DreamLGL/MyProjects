package com.lgl.therad.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lgl
 * @Description: 线程池
 * JDK1.5之后提供的java.util.concurrent.Executors: 线程池的工厂类,用来生成线程池
 * Executors类中的静态方法:
 * static ExecutorService newFixedThreadPool(int nThreads)创建一个线程池，重用固定数量的线程，从共享无界队列中运行，使用提供的ThreadFactory在需要时创建新线程。
 * 参数:
 * int nThreads: 创建线程池中包含的线程数量
 * 返回值:
 * ExecutorService 接口,返回的是ExecutorService接口的实现类对象,我们可以使用ExecutorService接口接收(面向接口编程)
 * <p>
 * java.util.concurrent.ExecutorService: 线程池接口
 * 用来从线程池中获取线程,调用start方法,执行线程任务
 * submit(Runnable task) 提交一个Runnable任务用于执行
 * 关闭/销毁线程池的方法
 * shutdown()
 * 线程池的使用步骤:
 * 1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
 * 2.创建一个类,实现Runnable接口,重写run方法.设置线程任务
 * 3.调用ExecutorService接口中的submit,传统线程任务(实现类),开启线程,执行run方法
 * 4.调用ExecutorService接口中的shutdowm销毁线程池(不建议使用)
 * @date 2020/3/15 4:59 下午
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        //1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.shutdown();
    }
}
