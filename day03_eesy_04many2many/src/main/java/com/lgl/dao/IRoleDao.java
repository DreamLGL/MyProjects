package com.lgl.dao;

import com.lgl.domain.Role;

import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2019/11/21 11:53 下午
 */
public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
