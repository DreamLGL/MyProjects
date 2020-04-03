package com.lgl.dao;

import com.lgl.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lgl
 * @Description: 用户的持久层接口
 * @date 2019/10/23 11:41 下午
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
