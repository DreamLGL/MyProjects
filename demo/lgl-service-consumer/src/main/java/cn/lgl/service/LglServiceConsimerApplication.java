package cn.lgl.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient //开启eureka
//@EnableCircuitBreaker //开启熔断

@SpringCloudApplication //组合注解,相当于 @SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker
@EnableFeignClients //启用Feign组件
public class LglServiceConsimerApplication {

//	@Bean
//	@LoadBalanced //开启负载均衡(默认为轮询)
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(LglServiceConsimerApplication.class, args);
	}

}
