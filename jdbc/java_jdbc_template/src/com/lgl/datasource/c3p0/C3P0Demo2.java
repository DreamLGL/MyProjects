package com.lgl.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lgl
 * @Description: c3p0的演示
 * @date 2019-07-22 23:02
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        /*//1.创建数据库连接池对象 使用默认配置
        DataSource dataSource = new ComboPooledDataSource("otherc3p0");
        //2.获取连接对象
        for (int i = 0; i < 11; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":" + connection);
            if (i == 5) {
                connection.close();
            }
        }*/
        testNameCibfig();
    }

    public static void testNameCibfig() throws SQLException {
        //1.1获取指定配置
        DataSource dataSource = new ComboPooledDataSource();
        //2.获取连接对象
        for (int i = 0; i < 11; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":" + connection);
            if (i == 5) {
                connection.close();
            }
        }

    }
}
