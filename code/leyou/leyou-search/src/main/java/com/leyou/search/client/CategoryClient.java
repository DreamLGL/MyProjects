package com.leyou.search.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lgl
 * @Description: Category的fen接口
 * @date 2020/2/19 4:32 下午
 */
@FeignClient(value = "item-service",contextId = "category")
public interface CategoryClient extends CategoryApi {
}
