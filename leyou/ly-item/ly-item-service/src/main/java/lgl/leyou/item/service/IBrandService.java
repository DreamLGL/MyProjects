package lgl.leyou.item.service;

import lgl.leyou.common.vo.PageResult;
import lgl.leyou.ltem.pojo.Brand;

/**
 * @author lgl
 * @Description: 品牌service接口
 * @date 2020/1/9 11:20 下午
 */
public interface IBrandService {
    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key);
}
