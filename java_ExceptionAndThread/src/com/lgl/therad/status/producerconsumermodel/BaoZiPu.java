package com.lgl.therad.status.producerconsumermodel;

/**
 * @author lgl
 * @Description: 生产者:包子铺
 * 注意:
 * 包子铺线程和包子线程关系-->通信(互斥)
 * 必须使用同步技术保证两个线程只有一个在执行
 * 锁对象必须保证唯一,可以使用包子对象作为锁对象
 * 包子铺和吃货的类就需要把包子对象作为参数传递进来
 * 1.需要在成员位置创建一个包子变量
 * 2.使用带参数构造方法,为这个包子变量赋值
 * @date 2020/3/15 4:24 下午
 */
public class BaoZiPu extends Thread {
    /**
     * 1.需要在成员位置创建一个包子变量
     */
    private BaoZi baoZi;

    /**
     * 2.使用带参数构造方法,为这个包子变量赋值
     *
     * @param baoZi
     */
    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    /**
     * 设置线程任务(run):生产包子
     */
    @Override
    public void run() {
        int count = 0;
        while (true){
            // 必须使用同步技术保证两个线程只有一个在执行
            synchronized (baoZi) {
                // 对包子的状态进行判断
                if (baoZi.status == true) {
                    try {
                        //包子铺调用wait方法进入等待状态
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒后执行,包子铺生产包子
                //增加一些趣味:交替生产两种包子
                if (count % 2 == 0) {
                    //生产 薄皮三鲜包子
                    baoZi.pi = "薄皮";
                    baoZi.xian = "三鲜馅";
                } else {
                    //生产 冰皮牛肉大葱包子
                    baoZi.pi = "冰皮";
                    baoZi.xian = "牛肉大葱馅";
                }
                count++;
                System.out.println("包子铺正在生产" + baoZi.pi + baoZi.xian + "包子");
                // 生产把包子需要3秒钟
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(baoZi.pi + baoZi.xian + "包子生产好了");
                //包子铺生产好了包子,修改包子状态为true
                baoZi.status = true;
                //唤醒吃货线程,让吃货线程吃包子
                baoZi.notify();
            }
        }
    }
}
