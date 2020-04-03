package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;

import java.util.List;

/**
 * @author lgl
 * @Description: 品牌信息service接口
 * @date 2020/2/2 5:00 下午
 */
public interface IBrandService {
    /**
     * 根据分页查询条件查询品牌信息
     *
     * @param key    搜索条件
     * @param page   当前页
     * @param rows   每页大小
     * @param sortBy 排序字段
     * @param desc   是否降序
     * @return
     */
    PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 新增品牌
     *
     * @param brand 新增品牌信息
     * @param cids  品牌分类信息
     */
    void saveBrand(Brand brand, List<Long> cids);

    /**
     * 根据分类id(cid)查询品牌信息
     *
     * @param cid
     * @return
     */
    List<Brand> queryBrandsByCid(Long cid);

    /**
     * 根据id查询品牌信息
     * @param id
     * @return
     */
    Brand queryBrandById(Long id);
}
