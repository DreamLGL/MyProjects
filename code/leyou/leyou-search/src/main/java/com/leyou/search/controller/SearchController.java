package com.leyou.search.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.search.bo.SearchResult;
import com.leyou.search.pojo.Goods;
import com.leyou.search.pojo.SearchRequest;
import com.leyou.search.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgl
 * @Description: SearchController
 * @date 2020/2/20 11:42 下午
 */
@RestController
public class SearchController {
    @Autowired
    private SearchServiceImpl searchService;

    /**
     * 根据条件分页查询数据
     *
     * @param request
     * @return
     */
    @PostMapping("/page")
    public ResponseEntity<SearchResult> search(@RequestBody SearchRequest request) {
        SearchResult result = searchService.search(request);
        if (result == null || CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
