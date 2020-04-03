package com.leyou.search.client;

import com.leyou.item.api.GoodsApi;
import com.leyou.item.pojo.SpuDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lgl
 * @Description: Goods的fen接口
 * @date 2020/2/19 4:11 下午
 */
@FeignClient(value = "item-service",contextId = "goods")
public interface GoodsClient extends GoodsApi {

}
