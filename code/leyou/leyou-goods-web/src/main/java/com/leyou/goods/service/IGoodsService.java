package com.leyou.goods.service;

import java.util.Map;

/**
 * @author lgl
 * @Description: service层
 * @date 2020/2/27 10:29 下午
 */
public interface IGoodsService {
    /**
     * 根据spuId返回商品详情
     *
     * @param spuId
     * @return
     */
    Map<String, Object> loadData(Long spuId);
}
