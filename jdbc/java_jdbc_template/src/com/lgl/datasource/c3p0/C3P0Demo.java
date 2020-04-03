package com.lgl.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lgl
 * @Description: c3p0的演示
 * @date 2019-07-22 23:02
 */
public class C3P0Demo {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象
        DataSource dataSource = new ComboPooledDataSource();
        //2.获取连接对象
        Connection connection = dataSource.getConnection();
        //3.打印
        System.out.println(connection);
    }
}
