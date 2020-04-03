package com.lgl.therad.safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lgl
 * @Description: 实现卖票案例:
 * 解决线程安全问题的第三种方案:使用Lock锁
 * java.util.concurrent.locks接口
 * Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作.
 * Lock接口中的方法
 *  void lock() 获取锁
 *  void unlock() 释放锁
 * java.util.concurrent.locks.ReentrantLock implements Lock接口
 * 使用步骤:
 *  1. 在成员位置创建一个ReentrantLock对象
 *  2. 在可能出现线程安全问题的代码前调用Lock接口中的方法lock()获取锁
 *  3. 在可能出现线程安全问题的代码后调用Lock接口中的方法unlock()释放锁
 * @date 2020/3/14 4:41 下午
 */
public class RunnableImplSafe4 implements Runnable {
    /**
     * 定义一个多个线程共享的票源
     */
    private int totalTicket = 100;
    /**
     * 定义正在卖的票
     */
    private Integer saleTicket = 1;

    /**
     * 1. 在成员位置创建一个ReentrantLock对象
     */
    Lock lock = new ReentrantLock();

    /**
     * 卖票
     */
    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (totalTicket > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "---->正在卖第" + saleTicket + "张票");
                    totalTicket--;
                    saleTicket++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            if(totalTicket == 0){
                break;
            }
        }
    }
}
