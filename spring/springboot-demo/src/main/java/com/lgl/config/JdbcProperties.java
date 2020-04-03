package com.lgl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lgl
 * @Description: SpringBoot的java配置方式
 * @date 2019/12/22 11:24 下午
 */
//@ConfigurationProperties(prefix = "jdbc")
@Data
public class JdbcProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
