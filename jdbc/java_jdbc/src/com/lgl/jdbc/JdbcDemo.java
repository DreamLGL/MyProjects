package com.lgl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author lgl
 * @Description: jdbc快速入门
 * @date 2019-07-18 23:44
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql:///travel", "root", "root");
        //4.定义SQL语句
        String sql = "select * from tab_seller";
        //5.获取执行SQL的对象
        Statement statement = connection.createStatement();
        //6.执行SQL
        ResultSet resultSet = statement.executeQuery(sql);
        //7.输出结果
        System.out.println(resultSet);
        //8.关闭连接
        statement.close();
        connection.close();
    }
}
