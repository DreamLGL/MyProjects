package com.lgl.ssm.dao;

import com.lgl.ssm.domain.Role;
import com.lgl.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lgl
 * @Description: user的dao接口
 * @date 2019/12/15 12:25 上午
 */
public interface IUserDao {
    /**
     * 查询所有user的信息
     *
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 根据登录名查询登录信息
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.lgl.ssm.dao.IRoleDao.findRoleByUserId")),
    }
    )
    public UserInfo findByUserName(String username) throws Exception;

    /**
     * 添加用户
     *
     * @param userInfo
     * @throws Exception
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据id获取指定的用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.lgl.ssm.dao.IRoleDao.findRoleByUserId")),
    })
    UserInfo findById(String id) throws Exception;

    /**
     * 查出用户没有的角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(String userId) throws Exception;

    /**
     * 给用户添加角色
     *
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role(userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;
}
