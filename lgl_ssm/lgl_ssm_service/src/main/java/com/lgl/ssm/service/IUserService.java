package com.lgl.ssm.service;

import com.lgl.ssm.domain.Role;
import com.lgl.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author lgl
 * @Description: user的service接口
 * @date 2019/12/15 12:24 上午
 */
public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 添加用户信息
     * @param userInfo
     * @throws Exception
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 获取指定ID的用户信息
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo findById(String id) throws Exception;

    /**
     * 根据用户id查询可以添加的角色
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> findOtherRoles(String userId) throws Exception;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
