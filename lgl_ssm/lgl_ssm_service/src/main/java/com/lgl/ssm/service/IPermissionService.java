package com.lgl.ssm.service;

import com.lgl.ssm.domain.Permission;

import java.util.List;

/**
 * @author lgl
 * @Description: permission的service接口
 * @date 2019/12/17 11:08 下午
 */
public interface IPermissionService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<Permission> findAll() throws Exception;

    /**
     * 保存权限
     * @param permission
     * @throws Exception
     */
    void savePermission(Permission permission) throws Exception;
}
