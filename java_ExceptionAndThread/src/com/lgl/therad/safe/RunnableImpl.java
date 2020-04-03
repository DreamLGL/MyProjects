package com.lgl.therad.safe;

/**
 * @author lgl
 * @Description: 实现卖票案例
 * @date 2020/3/14 4:41 下午
 */
public class RunnableImpl implements Runnable {
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
        while (true) {
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
