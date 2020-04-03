package com.lgl.user.controller;

import com.lgl.user.pojo.User;
import com.lgl.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/24 11:31 下午
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
