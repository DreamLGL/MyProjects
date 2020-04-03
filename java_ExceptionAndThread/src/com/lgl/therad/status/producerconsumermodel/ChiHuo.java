package com.lgl.therad.status.producerconsumermodel;

/**
 * @author lgl
 * @Description: 消费者:吃货
 * @date 2020/3/15 4:43 下午
 */
public class ChiHuo extends Thread {
    /**
     * 1.需要在成员位置创建一个包子变量
     */
    private BaoZi baoZi;

    /**
     * 2.使用带参数构造方法,为这个包子变量赋值
     *
     * @param baoZi
     */
    public ChiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true){
            synchronized (baoZi){
                // 判断包子状态
                if (baoZi.status==false){
                    try {
                        // 没有,吃货调用wait方法进入等待状态
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 被唤醒之后执行的代码,吃包子
                System.out.println("吃货正在吃" + baoZi.pi + baoZi.xian + "包子");
                // 吃包子需要1秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("吃货已经把" + baoZi.pi + baoZi.xian + "包子吃完了,包子铺开始生产包子");
                baoZi.status=false;
                baoZi.notify();
                System.out.println("---------------------------------------------------------------------------------------------------");
            }
        }
    }
}
