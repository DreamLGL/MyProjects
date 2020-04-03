package com.lgl.controller;

import com.lgl.domain.Items;
import com.lgl.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/2 11:52 下午
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private IItemsService itemsService;

    @RequestMapping("/findDetail")
    public String findDetail(Model model,Integer id){
        Items items = itemsService.findById(1);
        model.addAttribute("item",items);
        return "itemDetail";
    }
}
