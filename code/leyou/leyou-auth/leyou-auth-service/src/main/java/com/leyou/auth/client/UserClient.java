package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lgl
 * @Description: fen调用user-service的接口
 * @date 2020/3/7 11:14 下午
 */
@FeignClient(value = "user-service", contextId = "user")
public interface UserClient extends UserApi {
}
