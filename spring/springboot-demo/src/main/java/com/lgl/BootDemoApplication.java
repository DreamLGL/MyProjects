package com.lgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lgl
 * @Description: SpringBoot快速入门demo
 *  当引入了mybatis通用mapper过后MapperScan注解要使用tk.mybatis.spring.annotation.MapperScan;而不是mybatis的该注解
 * @date 2019/12/22 10:38 下午
 */
@SpringBootApplication
@MapperScan("com.lgl.mapper")
public class BootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class);
    }
}
