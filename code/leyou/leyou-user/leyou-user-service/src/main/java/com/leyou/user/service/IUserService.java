package com.leyou.user.service;

import com.leyou.user.pojo.User;

/**
 * @author lgl
 * @Description: UserService接口
 * @date 2020/3/3 4:16 下午
 */
public interface IUserService {
    /**
     * 根据数据和类型进行校验,判断用户名和手机是否已经注册使用
     *
     * @param data 要校验的数据
     * @param type 要校验的数据类型：1，用户名；2，手机；
     * @return
     */
    Boolean checkUser(String data, Integer type);

    /**
     * 发送随机验证码
     *
     * @param phone
     */
    void sendVerifyCode(String phone);

    /**
     * 用户注册
     *
     * @param user
     * @param code
     */
    void register(User user, String code);

    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    User queryUser(String username, String password);
}
