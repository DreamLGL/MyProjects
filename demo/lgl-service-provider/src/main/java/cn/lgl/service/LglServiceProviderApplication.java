package cn.lgl.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.lgl.service.dao")
@EnableDiscoveryClient
public class LglServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LglServiceProviderApplication.class, args);
    }

}
