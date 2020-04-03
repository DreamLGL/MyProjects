package com.lgl.controller;

import com.lgl.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lgl
 * @Description:
 * @date 2019/10/22 11:23 下午
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws Exception {
        System.out.println("testException执行了...");
        try {
            //模拟异常
            int a = 10 / 0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义信息
            throw new SysException("查询所有的用户出现错误了...");
        }
        return "success";
    }
}
