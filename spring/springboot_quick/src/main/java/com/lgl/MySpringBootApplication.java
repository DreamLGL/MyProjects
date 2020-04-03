package com.lgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lgl
 * @Description: 引导bean
 *      SpringBootApplication注解:声明该类是一个SpringBoot引导类
 * @date 2019/12/21 11:24 下午
 */
@SpringBootApplication
public class MySpringBootApplication {
    /**
     * main是Java程序的入口
     * @param args
     */
    public static void main(String[] args) {
        /**
         * run方法:表示运行SpringBoot的引导类 run的参数就是SpringBoot引导类的字节码对象
         */
        SpringApplication.run(MySpringBootApplication.class);
    }
}
