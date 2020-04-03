package com.lgl.mybatis.utils;

import com.lgl.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author lgl
 * @Description: 用于创建数据源的工具类
 * @date 2019/11/5 12:04 上午
 */
public class DataSourceUtil {
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
