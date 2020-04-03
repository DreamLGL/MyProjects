package com.lgl.ssm.dao;

import com.lgl.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lgl
 * @Description: permission的dao层接口
 * @date 2019/12/16 11:42 下午
 */
public interface IPermissionDao {
    /**
     * 根据RoleId查询角色权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;


    /**
     * 查询所有
     *
     * @return
     * @throws Exception
     */
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    /**
     * 保存权限
     *
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void savePermission(Permission permission) throws Exception;
}
