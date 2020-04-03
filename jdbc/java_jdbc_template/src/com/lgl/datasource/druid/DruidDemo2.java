package com.lgl.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lgl.uitl.JDBCUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author lgl
 * @Description: 使用新的工具类
 * @date 2019-07-22 23:26
 */
public class DruidDemo2 {
    public static void main(String[] args) throws Exception {
        /**
         * 完成添加操作
         */
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();
            //1.1开启事务
            connection.setAutoCommit(false);
            System.out.println("开启事务");
            //2.定义sql'
            String sql = "insert into user(id,username,sex,address) values(?,?,?,?)";
            //3.获取preparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            //4.给?赋值
            preparedStatement.setInt(1, 44);
            preparedStatement.setString(2, "李四");
            preparedStatement.setString(3, "女");
            preparedStatement.setString(4, "成都");
            System.out.println("执行Sql: "+sql);
            //5.执行sql
            int count = preparedStatement.executeUpdate();
            System.out.println(count);
            //事务提交
            System.out.println("执行成功,提交事务!");
            connection.commit();
        } catch (Exception e) {
            //事务回滚
            System.out.println("执行出错,回滚事务......");
            connection.rollback();
            e.printStackTrace();
        } finally {
            //6.释放资源
            JDBCUtils.close(preparedStatement,connection);
        }
    }
}
