package com.lgl.therad.safe;

/**
 * @author lgl
 * @Description: 实现卖票案例:
 * 解决线程安全问题的第二种方案:使用同步方法
 * 使用步骤:
 * 1. 把访问了共享数据的代码抽取出来,放到一个方法中
 * 2. 在方法上添加synchronized修饰符
 * 定义方法的格式:
 * 修饰符 synchronized 返回值类型 方法名(参数列表){
 * 可能会出现线程安全问题的代码(访问共享数据的代码)
 * }
 * @date 2020/3/14 4:41 下午
 */
public class RunnableImplSafe2 implements Runnable {
    /**
     * 定义一个多个线程共享的票源
     */
    private int totalTicket = 100;
    /**
     * 定义正在卖的票
     */
    private Integer saleTicket = 1;

    /**
     * 卖票
     */
    @Override
    public void run() {
        System.out.println(this);
        while (true) {
            if (this.totalTicket == 0) {
                break;
            }
            payTicket();

        }
    }

    /**
     * 定义一个同步方法
     * 同步方法也会把方法内部的代码锁住,只让一个线程执行
     * 同步方法的锁对象是谁?
     * 就是实现类对象new RunnableImplSafe2,也就是this
     */
    public synchronized void payTicket() {
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
        }
    }
}
