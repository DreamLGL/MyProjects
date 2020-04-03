package com.lgl.test;

import com.lgl.config.SpringConfig;
import com.lgl.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lgl
 * @Description: AOP测试
 * @date 2019/8/31 11:41 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AOPTest {
    @Test
    public void test() {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        //2.获取对象
        AccountService as = (AccountService) ac.getBean("accountService",AccountService.class);
        //3.执行方法
        as.saveAccount();
    }
}
