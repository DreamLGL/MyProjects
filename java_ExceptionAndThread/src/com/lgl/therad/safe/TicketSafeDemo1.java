package com.lgl.therad.safe;

/**
 * @author lgl
 * @Description: 模拟卖票案例
 * @date 2020/3/14 4:49 下午
 */
public class TicketSafeDemo1 {
    public static void main(String[] args) {
        RunnableImplSafe1 r = new RunnableImplSafe1();
        Thread t = new Thread(r);
        t.start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
