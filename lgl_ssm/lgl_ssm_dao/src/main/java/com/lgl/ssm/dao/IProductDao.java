package com.lgl.ssm.dao;

import com.lgl.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lgl
 * @Description: productDao层
 * @date 2019/12/10 11:54 下午
 */
public interface IProductDao {
    /**
     * 查询所有产品信息
     *
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    /**
     * 保存product
     *
     * @param product
     */
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 根据ID查询Product
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id = #{id}")
    public Product findById(String id) throws Exception;
}
