package com.lgl.ssm.service;

import com.lgl.ssm.domain.Product;

import java.util.List;

/**
 * @author lgl
 * @Description: produceService层
 * @date 2019/12/10 11:56 下午
 */
public interface IProductService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;

    /**
     * 保存
     * @param product
     */
    void save(Product product) throws Exception;
}
