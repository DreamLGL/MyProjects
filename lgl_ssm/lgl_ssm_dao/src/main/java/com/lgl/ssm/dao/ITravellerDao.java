package com.lgl.ssm.dao;

import com.lgl.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/14 10:23 下午
 */
public interface ITravellerDao {
    /**
     * 根据订单id查询用户信息
     *
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from TRAVELLER where id in(select travellerid from ORDER_TRAVELLER where ORDERID = #{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
