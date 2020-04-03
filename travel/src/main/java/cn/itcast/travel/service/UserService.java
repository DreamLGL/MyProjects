package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

/**
 * @author lgl
 * @Description: user的接口
 * @date 2019-08-01 22:38
 */
public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    Boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
