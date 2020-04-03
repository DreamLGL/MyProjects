package com.leyou.goods.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lgl
 * @Description: Brand的fen接口
 * @date 2020/2/19 4:31 下午
 */
@FeignClient(value = "item-service",contextId = "webBrand")
public interface BrandClient extends BrandApi {
}
