package com.lgl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author lgl
 * @Description: jdbc配置类
 * @date 2019/12/22 10:58 下午
 */
//@Configuration
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {
//    @Value("${jdbc.driverClassname}")
//    private String driverClassName;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.password}")
//    private String password;

    /*@Autowired
    JdbcProperties jdbcProperties;

    public JdbcConfig(JdbcProperties jdbcProperties){
        this.jdbcProperties = jdbcProperties;
    }*/

    /*@Bean
    public DataSource dataSource(JdbcProperties prop) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(prop.getDriverClassName());
        dataSource.setUrl(prop.getUrl());
        dataSource.setUsername(prop.getUsername());
        dataSource.setPassword(prop.getPassword());
        return dataSource;
    }*/

//    @Bean
//    @ConfigurationProperties(prefix = "jdbc")
//    public DataSource dataSource() {
//        return new DruidDataSource();
//    }
}
