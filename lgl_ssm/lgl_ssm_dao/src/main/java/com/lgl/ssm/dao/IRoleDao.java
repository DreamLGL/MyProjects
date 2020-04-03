package com.lgl.ssm.dao;

import com.lgl.ssm.domain.Permission;
import com.lgl.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lgl
 * @Description: 角色的dao
 * @date 2019/12/15 5:03 下午
 */
public interface IRoleDao {
    /**
     * 根据userId查询用户所有对应角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleid from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = List.class, many = @Many(select = "com.lgl.ssm.dao.IPermissionDao.findPermissionByRoleId")),
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 保存Role
     *
     * @param role
     * @throws Exception
     */
    @Insert("insert into role(rolename,roledesc) values(#{roleName},#{roleDesc})")
    void saveRole(Role role) throws Exception;

    /**
     * 根据roleId查询role
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id = #{roleId}")
    Role findById(String roleId) throws Exception;

    /**
     * 根据roleId查询出没有的权限
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId}  )")
    List<Permission> findOtherPermissions(String roleId) throws Exception;

    /**
     * 给角色添加权限
     *
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Insert("insert into role_permission (permissionId,roleId) values (#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;
}
