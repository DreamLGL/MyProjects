package com.lgl.proxy;

/**
 * @author lgl
 * @Description: 一个生产者(动态代理)
 * @date 2019/8/28 11:09 下午
 */
public class Producer implements IProducer{
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("销售产品,并拿到钱:" + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money) {
        System.out.println("提供售后服务,并拿到钱:" + money);
    }
}
