package com.lgl.therad.safe;

/**
 * @author lgl
 * @Description: 模拟卖票案例
 * @date 2020/3/14 4:49 下午
 */
public class TicketDemo1 {
    public static void main(String[] args) {
        RunnableImpl r = new RunnableImpl();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}
