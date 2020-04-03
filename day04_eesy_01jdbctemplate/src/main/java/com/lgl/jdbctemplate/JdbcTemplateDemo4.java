package com.lgl.jdbctemplate;

import com.lgl.dao.IAccountDao;
import com.lgl.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lgl
 * @Description: JdbcTemplate的最基本用法
 * @date 2019/9/10 12:06 上午
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {

        //1. 获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2. 获取对象
        IAccountDao accountDao = applicationContext.getBean("accountDao",IAccountDao.class);
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
        account.setMoney(30000f);
        accountDao.updateAccount(account);
    }
}
