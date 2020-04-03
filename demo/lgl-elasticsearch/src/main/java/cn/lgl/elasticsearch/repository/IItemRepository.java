package cn.lgl.elasticsearch.repository;

import cn.lgl.elasticsearch.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2020/2/17 10:35 下午
 */
public interface IItemRepository extends ElasticsearchRepository<Item,Long>{
    /**
     * 根据标题查询
     * @param title
     * @return
     */
    List<Item> findByTitle(String title);

    /**
     * 查找价格之间
     * @param d1
     * @param d2
     * @return
     */
    List<Item> findByPriceBetween(Double d1,Double d2);
}
