package com.lgl.therad.method;

/**
 * @author lgl
 * @Description:sleep():使当前正在执行的线程以指定的毫秒数暂停(暂时停止执行)
 * @date 2020/3/14 4:18 下午
 */
public class Demo3Sleep {
    public static void main(String[] args) {
        //模拟秒表
        for (int i = 1; i <= 60; i++) {
            System.out.println(i);
            //使用Thread类的sleep方法让程序睡眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
