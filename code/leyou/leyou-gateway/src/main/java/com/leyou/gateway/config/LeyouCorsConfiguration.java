package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author lgl
 * @Description: 跨域配置
 * @date 2020/2/2 4:23 下午
 */
@Configuration
public class LeyouCorsConfiguration {
    @Bean
    public CorsFilter corsFilter() {
        //初始化cors配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //设置允许跨域的域名,如果要携带cookie,不能写*. *: 代表所有域名都可以跨域访问
        corsConfiguration.addAllowedOrigin("http://manage.leyou.com");
        corsConfiguration.addAllowedOrigin("http://www.leyou.com");
        //设置是否允许携带cookie
        corsConfiguration.setAllowCredentials(true);
        //设置允许的请求方法,*: 代表所有的请求方法:GET,POST,PUT,DELETE...
        corsConfiguration.addAllowedMethod("*");
        //设置允许携带的头信息,*: 代表允许携带任何头信息
        corsConfiguration.addAllowedHeader("*");

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        //返回corsFilter实例,参数:cors配置源对象
        return new CorsFilter(corsConfigurationSource);
    }
}
