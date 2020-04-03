package com.lgl.ui;

import com.lgl.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lgl
 * @Description: 模拟一个表现层, 用于调用业务层
 * @date 2019-08-23 23:29
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//推荐方式
        //2.根据id获取Bean对象
//        IAccountService service = (IAccountService) ac.getBean("accountService");
//        service.saveAccount();

//        IAccountService service = (IAccountService) ac.getBean("accountService2");
//        service.saveAccount();

        IAccountService service = (IAccountService) ac.getBean("accountService3");
        service.saveAccount();
    }
}
