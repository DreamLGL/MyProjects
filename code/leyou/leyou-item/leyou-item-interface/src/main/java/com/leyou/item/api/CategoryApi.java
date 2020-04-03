package com.leyou.item.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author lgl
 * @Description: Category的Api
 * @date 2020/2/19 4:26 下午
 */
@RequestMapping("/category")
public interface CategoryApi {

    /**
     * 根据ids查询名称
     *
     * @param ids
     * @return
     */
    @GetMapping()
    public List<String> queryNamesByIds(@RequestParam("ids") List<Long> ids);
}
