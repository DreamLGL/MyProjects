package com.lgl.test;

import com.lgl.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lgl
 * @Description: AOP测试
 * @date 2019/8/31 11:41 上午
 */
public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();

    }
}
