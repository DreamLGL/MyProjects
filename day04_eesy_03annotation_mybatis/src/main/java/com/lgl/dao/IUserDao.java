package com.lgl.dao;

import com.lgl.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lgl
 * @Description: 用户的接口
 * 在mybatis中针对,CRUD一共有四个注解
 *   @Select:
 *   @Insert:
 *   @Update:
 *   @Delete:
 * @date 2019/11/25 11:36 下午
 */
public interface IUserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},sex=#{sex},address=#{address} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id=#{id}")
    void deleteUserById(Integer id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);

    /**
     * 根据名称查询用户(模糊查询)
     * @param name
     * @return
     */
//    @Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%' ")
    List<User> findUserByName(String name);

    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user ")
    int findTotalUser();
}
