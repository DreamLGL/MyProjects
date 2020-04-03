package com.lgl.therad;

import com.lgl.therad.pojo.Person;

/**
 * @author lgl
 * @Description: 主线程:执行主方法(main)的线程
 *  单线程程序: Java程序中只有一个线程,执行从mian方法开始从上到下依次执行
 * @date 2020/3/14 3:30 下午
 */
public class Demo1MainThread {
    public static void main(String[] args) {
        Person p1 = new Person("小强");
        p1.run();

        Person p2 = new Person("旺财");
        p2.run();
    }
}
