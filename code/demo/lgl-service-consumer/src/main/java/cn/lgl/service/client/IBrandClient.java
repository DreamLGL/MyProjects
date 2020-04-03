package cn.lgl.service.client;

import cn.lgl.service.pojo.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lgl
 * @Description:
 * @date 2020/1/21 4:46 下午
 */
@FeignClient(value = "lgl-service-provider",fallback = BrandClientFallback.class)
public interface IBrandClient {
    @GetMapping("/brand/queryUserById")
    public Brand queryUserByid(@RequestParam(name = "id",required = true) Long id);
}
