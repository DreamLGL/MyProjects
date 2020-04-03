package com.lgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author lgl
 * @Description: consumer启动类
 *      LoadBalanced:负载均衡的注解
 *      EnableDiscoveryClient:启用熔断注解
 *      EnableCircuitBreaker:启用eureka注解
 *      SpringBootApplication注解 + EnableDiscoveryClient注解 + EnableCircuitBreaker注解 = SpringCloudApplication注解
 *      EnableFeignClients:启用Feign注解(开启次注解过后就不用再自己初始化使用RestTemplate类了,LoadBalanced注解也不需要了)
 * @date 2019/12/24 11:42 下午
 */
//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@EnableFeignClients
@SpringCloudApplication
public class ConsumerApplication {
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }
}
