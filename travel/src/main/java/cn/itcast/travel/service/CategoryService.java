package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @author lgl
 * @Description: CategroyService
 * @date 2019-08-21 23:12
 */
public interface CategoryService {
    public List<Category> findAll();
}
