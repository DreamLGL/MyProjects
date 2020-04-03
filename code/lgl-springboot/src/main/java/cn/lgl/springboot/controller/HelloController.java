package cn.lgl.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgl
 * @Description:
 * @date 2020/1/11 1:00 上午
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/test")
    public String test() {
        return "hello springboot 1";
    }
}
