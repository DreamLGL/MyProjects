package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

/**
 * @author lgl
 * @Description: 分类信息service层接口
 * @date 2020/2/2 3:23 下午
 */
public interface ICategoryService {
    /**
     * 根据父节点id去查询子节点的分类信息
     * @param pid 父节点的id
     * @return
     */
    List<Category> queryCategoriesByPid(Long pid);

    /**
     * 根据id返回名称
     * @param ids
     * @return
     */
    List<String> queryNamesByIds(List<Long> ids);
}
