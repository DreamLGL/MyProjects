package com.leyou.goods.controller;

import com.leyou.goods.service.impl.GoodsHtmlServiceImpl;
import com.leyou.goods.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @author lgl
 * @Description:
 * @date 2020/2/26 12:06 上午
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;
    @Autowired
    private GoodsHtmlServiceImpl goodsHtmlService;

    @GetMapping("/item/{id}.html")
    public String toItemPage(@PathVariable("id") Long id, Model model) {
        Map<String, Object> map = goodsService.loadData(id);
        model.addAllAttributes(map);
//        goodsHtmlService.createHtml(id); // 调用生成静态页面
        return "item";
    }
}
