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
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据ID删除用户
     *
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据Id查询用户
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();
}
