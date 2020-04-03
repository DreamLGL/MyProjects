package com.lgl.therad.status.producerconsumermodel;

/**
 * @author lgl
 * @Description: 测试类
 * @date 2020/3/15 4:50 下午
 */
public class Demo {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        new BaoZiPu(baoZi).start();
        new ChiHuo(baoZi).start();
    }
}
