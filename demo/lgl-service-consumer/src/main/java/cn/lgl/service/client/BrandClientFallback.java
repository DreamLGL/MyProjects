package cn.lgl.service.client;

import cn.lgl.service.pojo.Brand;
import org.springframework.stereotype.Component;

/**
 * @author lgl
 * @Description:
 * @date 2020/1/21 10:43 下午
 */
@Component
public class BrandClientFallback implements IBrandClient {
    @Override
    public Brand queryUserByid(Long id) {
        Brand brand = new Brand();
        brand.setName("服务器正忙,请稍后再试");
        return brand;
    }
}
