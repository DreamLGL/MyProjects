package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lgl
 * @Description: 启动引导类
 * @date 2020/1/31 4:06 下午
 */
@SpringBootApplication
@EnableEurekaServer
public class LeyouRegistryApplicayion {
    public static void main(String[] args) {
        SpringApplication.run(LeyouRegistryApplicayion.class);
    }
}
