package com.leyou.cart.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lgl
 * @Description: fen调用GoodsApi接口
 * @date 2020/3/10 4:42 下午
 */
@FeignClient(value = "item-service", contextId = "goods")
public interface GoodsClient extends GoodsApi {
}
