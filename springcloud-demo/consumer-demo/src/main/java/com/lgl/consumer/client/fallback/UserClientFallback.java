package com.lgl.consumer.client.fallback;

import com.lgl.consumer.client.UserClient;
import com.lgl.consumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author
 * @Description:
 * @date 2019/12/27 12:13 上午
 */
@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("未知用户");
        return user;
    }
}
