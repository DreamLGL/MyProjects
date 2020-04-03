package com.lgl.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author lgl
 * @Description: JdbcTemplate的最基本用法
 * @date 2019/9/10 12:06 上午
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {

        //1. 获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2. 获取对象

        JdbcTemplate jt = (JdbcTemplate) applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
        jt.execute("insert into account (name,money) values ('ccc',1000)");

    }
}
