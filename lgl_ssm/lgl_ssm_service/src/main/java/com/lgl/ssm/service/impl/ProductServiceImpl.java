package com.lgl.ssm.service.impl;

import com.lgl.ssm.dao.IProductDao;
import com.lgl.ssm.domain.Product;
import com.lgl.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lgl
 * @Description: productService实现类
 * @date 2019/12/10 11:58 下午
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
