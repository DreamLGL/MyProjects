package com.lgl.consumer.client;

import com.lgl.consumer.client.fallback.UserClientFallback;
import com.lgl.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lgl
 * @Description: user的客户端
 * @date 2019/12/26 11:45 下午
 */
@FeignClient(value = "user-service", fallback = UserClientFallback.class)
public interface UserClient {
    @RequestMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);
}
