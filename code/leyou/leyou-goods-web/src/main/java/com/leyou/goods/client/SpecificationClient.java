package com.leyou.goods.client;

import com.leyou.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lgl
 * @Description: Specification的fen接口
 * @date 2020/2/19 4:33 下午
 */
@FeignClient(value = "item-service",contextId = "webSpecification")
public interface SpecificationClient extends SpecificationApi {
}
