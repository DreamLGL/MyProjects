package lgl.leyou.item.service;

import lgl.leyou.ltem.pojo.Category;

import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2020/1/8 12:50 上午
 */
public interface ICategoryService {
    /**
     * 根据父节点id查询商品分类
     * @param pid
     * @return
     */
    List<Category> queryCategoryByPid(Long pid);
}
