package com.lgl.dao;

import com.lgl.domain.User;

import java.util.List;

/**
 * @author lgl
 * @Description: 用户的持久层接口
 * @date 2019/11/6 12:09 上午
 */
public interface IUserDao {
    /**
     * 查询所有用户,同时获取到用户下所有账户的信息
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据Id查询用户
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);
}
