package com.leyou.auth.service;

/**
 * @author lgl
 * @Description: auth的service接口
 * @date 2020/3/7 10:42 下午
 */
public interface IAuthService {
    /**
     * 根据用户名和密码验证
     * @param username
     * @param password
     * @return
     */
    String accredit(String username, String password);
}
