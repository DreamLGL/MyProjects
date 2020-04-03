package com.leyou.search.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Spu;
import com.leyou.search.pojo.Goods;
import com.leyou.search.pojo.SearchRequest;

/**
 * @author lgl
 * @Description: searchService接口
 * @date 2020/2/19 4:37 下午
 */
public interface ISearchService {
    /**
     * 根据spu构建goods
     *
     * @param spu
     * @return
     */
    Goods buildGoods(Spu spu) throws Exception;

    /**
     * 根据条件分页查询数据
     *
     * @param request
     * @return
     */
    PageResult<Goods> search(SearchRequest request);

    /**
     * 根据id保存goods
     * @param id
     */
    void save(Long id) throws Exception;

    /**
     * 根据id删除goods
     * @param id
     */
    void delete(Long id) throws Exception;
}
