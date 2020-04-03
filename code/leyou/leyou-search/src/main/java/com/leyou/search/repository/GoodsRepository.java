package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author lgl
 * @Description:
 * @date 2020/2/19 10:55 下午
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {
}
