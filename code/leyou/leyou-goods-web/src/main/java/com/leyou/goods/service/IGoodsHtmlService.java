package com.leyou.goods.service;

/**
 * @author lgl
 * @Description: 生成静态html的方法接口
 * @date 2020/3/1 4:23 下午
 */
public interface IGoodsHtmlService {
    /**
     * 创建静态html
     * @param spuId
     */
    void createHtml(Long spuId);

    /**
     * 删除静态页面
     * @param id
     */
    void deleteHtml(Long id);
}
