package com.leyou.goods.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lgl
 * @Description: Goods的fen接口
 * @date 2020/2/19 4:11 下午
 */
@FeignClient(value = "item-service",contextId = "webGoods")
public interface GoodsClient extends GoodsApi {

}
