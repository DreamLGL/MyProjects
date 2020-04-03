package com.leyou.item.api;

import com.leyou.item.pojo.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lgl
 * @Description: Brand接口Api
 * @date 2020/2/19 4:25 下午
 */
@RequestMapping("/brand")
public interface BrandApi {

    /**
     * 根据id查询品牌信息
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Brand queryBrandById(@PathVariable("id") Long id);
}
