package com.lgl.ssm.service;

import com.lgl.ssm.domain.Orders;

import java.util.List;

/**
 * @author lgl
 * @Description: 订单的接口
 * @date 2019/12/13 12:02 上午
 */
public interface IOrdersService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     * @param page
     * @param size
     */
    List<Orders> findAll(Integer page, Integer size) throws Exception;

    /**
     * 根据id查询订单详情
     * @param ordersId
     * @return
     * @throws Exception
     */
    Orders findById(String ordersId) throws Exception;
}
