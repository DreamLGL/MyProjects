package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @author lgl
 * @Description: 分类
 * @date 2019-08-21 23:06
 */
public interface CategoryDao {
    public List<Category> findAll();
}
