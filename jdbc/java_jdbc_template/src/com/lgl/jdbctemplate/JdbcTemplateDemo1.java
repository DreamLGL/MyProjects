package com.lgl.jdbctemplate;

import com.lgl.uitl.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author lgl
 * @Description: jdbctemplate 入门
 * @date 2019-07-23 23:36
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建jdbctemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update user set username='袁姗姗' where id = ?";
        int update = jdbcTemplate.update(sql, 41);
        System.out.println(update);
    }
}
