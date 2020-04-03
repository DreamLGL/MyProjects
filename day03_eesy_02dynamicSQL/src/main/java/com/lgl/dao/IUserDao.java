package com.lgl.dao;

import com.lgl.domain.QueryVo;
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
     * 根据QueryVo中的查询条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询条件:有可能由用户,有可能有性别,也有可能有地址,还有可能是都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的id集合,查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
