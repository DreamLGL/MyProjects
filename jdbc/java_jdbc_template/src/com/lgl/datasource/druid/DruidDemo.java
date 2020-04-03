package com.lgl.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author lgl
 * @Description: druid演示
 * @date 2019-07-22 23:26
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入架包
        //2.定义配置文件
        //3.加载配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        //4.获取连接对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //5.获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
