package com.lgl.controller;

import com.lgl.pojo.User;
import com.lgl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/22 10:41 下午
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {
//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @RequestMapping("{id}")
    public User hello(@PathVariable("id") Long id) {
        log.debug("hello method is running");
        return userService.queryById(id);
    }
}
