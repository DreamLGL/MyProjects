package com.lgl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/21 11:30 下午
 */
@Controller
@RequestMapping("/quick")
public class QuickController {
    @RequestMapping("/quick")
    @ResponseBody
    public String quick() {
        return "Hello SpringBoot";
    }
}
