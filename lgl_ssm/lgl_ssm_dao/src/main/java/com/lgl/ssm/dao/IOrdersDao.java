package com.lgl.ssm.dao;

import com.lgl.ssm.domain.Member;
import com.lgl.ssm.domain.Orders;
import com.lgl.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lgl
 * @Description: 订单的Dao层
 * @date 2019/12/13 12:07 上午
 */
public interface IOrdersDao {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.lgl.ssm.dao.IProductDao.findById"))
    })
    public List<Orders> findAll() throws Exception;

    /**
     * 根据ID查询订单详情
     * @param ordersId
     * @return
     * @throws Exception
     */

    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.lgl.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.lgl.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.lgl.ssm.dao.ITravellerDao.findByOrdersId"))

    })
    public Orders findById(String ordersId) throws Exception;
}
