package com.lgl.uitl;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author lgl
 * @Description: Druid连接池工具类
 * @date 2019-07-22 23:39
 */
public class JDBCUtils {
    //1.定义一个成员变量
    private static DataSource dataSource;

    static {
        try {
            //1.加载配置文件
            Properties ps = new Properties();
            ps.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取datasource
            dataSource = DruidDataSourceFactory.createDataSource(ps);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {

        return dataSource.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }

    /**
     * 释放资源
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池的方法
     *
     * @return
     */
    public static DataSource getDataSource() {

        return dataSource;
    }
}
