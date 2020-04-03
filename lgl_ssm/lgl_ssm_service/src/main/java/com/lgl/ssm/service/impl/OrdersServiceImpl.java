package com.lgl.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.lgl.ssm.dao.IOrdersDao;
import com.lgl.ssm.domain.Orders;
import com.lgl.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lgl
 * @Description: 订单接口的实现类
 * @date 2019/12/13 12:03 上午
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(Integer page, Integer size) throws Exception {
        //参数pageNum是页码值;参数pageSize代表的是每页显示条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
