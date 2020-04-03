package com.lgl.oracle;

import oracle.jdbc.OracleTypes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 * @author lgl
 * @Description: oracle测试
 * @date 2019/12/8 9:20 下午
 */
public class OracleDemo {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private CallableStatement callableStatement;
    private ResultSet rs;

    @Before
    public void init() throws Exception {
        //加载数据驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到连接
        connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.3.33:1521/orcl", "lgl", "cy5201314");
    }

    @After
    public void destroy() throws Exception {
        //释放资源
        if (rs != null) {
            rs.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (callableStatement != null) {
            callableStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }


    @Test
    public void javaCalloracle() throws Exception {
        //得到预编译的Statement对象
        preparedStatement = connection.prepareStatement("select * from emp where empno = ?");
        preparedStatement.setObject(1, 7788);
        //执行数据库查询操作
        rs = preparedStatement.executeQuery();
        //输出结果
        while (rs.next()) {
            System.out.println(rs.getString("ename"));
        }
    }

    /**
     * Java调用存储过程
     *
     * @throws Exception
     */
    @Test
    public void javaCallProcedure() throws Exception {
        //得到预编译的Statement对象
        callableStatement = connection.prepareCall("{call p_yearsal(?,?)}");
        callableStatement.setObject(1, 7788);
        callableStatement.registerOutParameter(2, OracleTypes.NUMBER);
        callableStatement.execute();
        System.out.println(callableStatement.getObject(2));
    }

    /**
     * Java调用存储函数
     *
     * @throws Exception
     */
    @Test
    public void javaCallFunction() throws Exception {
        //得到预编译的Statement对象
        callableStatement = connection.prepareCall("{?=call f_yearsal(?)}");
        callableStatement.setObject(2, 7788);
        callableStatement.registerOutParameter(1, OracleTypes.NUMBER);
        callableStatement.execute();
        System.out.println(callableStatement.getObject(1));
    }
}
