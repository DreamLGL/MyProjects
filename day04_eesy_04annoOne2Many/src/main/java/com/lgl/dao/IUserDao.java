package com.lgl.dao;

import com.lgl.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.lgl.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
     //标准写法
     // @ResultMap(value={"userMap"})
     //只有一个可以省略大括号
    @ResultMap("userMap")
    User findUserById(Integer id);

    /**
     * 根据名称查询用户(模糊查询)
     * @param name
     * @return
     */
    @ResultMap("userMap")
    @Select("select * from user where username like #{username}")

    List<User> findUserByName(String name);
}
