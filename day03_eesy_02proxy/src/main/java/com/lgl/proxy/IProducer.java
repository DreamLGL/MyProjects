package com.lgl.proxy;

/**
 * @author lgl
 * @Description:
 * @date 2019/8/28 11:14 下午
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
