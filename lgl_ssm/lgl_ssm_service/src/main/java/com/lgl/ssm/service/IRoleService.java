package com.lgl.ssm.service;

import com.lgl.ssm.domain.Permission;
import com.lgl.ssm.domain.Role;

import java.util.List;

/**
 * @author lgl
 * @Description: Role的Service层
 * @date 2019/12/17 10:32 下午
 */
public interface IRoleService {
    /**
     * 查询所有
     *
     * @return
     * @throws Exception
     */
    List<Role> findAll() throws Exception;

    /**
     * 保存role
     * @param role
     * @throws Exception
     */
    void saveRole(Role role) throws Exception;

    /**
     * 根据id查询Role
     * @param roleId
     * @return
     * @throws Exception
     */
    Role findById(String roleId) throws Exception;

    /**
     * 根据roleId查询没有的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> findOtherPermissions(String roleId) throws Exception;

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
