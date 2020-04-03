package com.leyou.auth.service.impl;

import com.leyou.auth.config.JwtProperties;
import com.leyou.auth.client.UserClient;
import com.leyou.common.pojo.UserInfo;
import com.leyou.common.utils.JwtUtils;
import com.leyou.auth.service.IAuthService;
import com.leyou.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lgl
 * @Description: authservice接口的实现类
 * @date 2020/3/7 10:43 下午
 */
@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private UserClient userClient;

    @Override
    public String accredit(String username, String password) {
        //1. 根据用户名和密码查询
        User user = userClient.queryUser(username, password);
        //2. 判断user
        if (user == null) {
            return null;
        }
        try {
            //3. jwtUtils生成jwt类型的token
            UserInfo userInfo = new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setUsername(user.getUsername());
            String token = JwtUtils.generateToken(userInfo, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
