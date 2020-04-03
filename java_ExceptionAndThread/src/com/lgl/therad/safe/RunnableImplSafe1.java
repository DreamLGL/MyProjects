package com.lgl.therad.safe;

/**
 * @author lgl
 * @Description: 实现卖票案例:
 * 解决线程安全问题的一种方案: 使用同步代码块
 * 格式:
 * synchronized(锁对象){
 * 可能会出现线程安全问题的代码(访问共享数据的代码)
 * }
 * 注意:
 * 1. 通过代码块中的锁对象,可以使用任意对象
 * 2. 但是必须保证多个线程使用的锁对象是同一个
 * 3. 锁对象作用:
 * 把同步代码块锁住,只让一个线程在同步代码块中执行
 * @date 2020/3/14 4:41 下午
 */
public class RunnableImplSafe1 implements Runnable {
    /**
     * 定义一个多个线程共享的票源
     */
    private int totalTicket = 100;
    /**
     * 定义正在卖的票
     */
    private Integer saleTicket = 1;
    /**
     * 创建一个锁对象
     */
    Object object = new Object();

    /**
     * 卖票
     */
    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (this.totalTicket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---->正在卖第" + this.saleTicket + "张票");
                    this.totalTicket--;
                    this.saleTicket++;
                } else {
                    System.out.println(Thread.currentThread().getName() + "---->票已经售光");
                    break;
                }
            }
        }
    }
}
