package com.lgl.therad.safe;

/**
 * @author lgl
 * @Description: 模拟卖票案例
 * @date 2020/3/14 4:49 下午
 */
public class TicketSafeDemo2 {
    public static void main(String[] args) {
        RunnableImplSafe2 r = new RunnableImplSafe2();
        System.out.println("run :"+r);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
