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
//        ApplicationContext ac = new FileSystemXmlApplicationContext("//Users/WorkSpace/day01_eesy_03spring/src/main/resources/bean.xml");
        //2.根据id获取Bean对象
        IAccountService service = (IAccountService) ac.getBean("accountService");
//        IAccountService service2 = (IAccountService) ac.getBean("accountService");
        service.saveAccount();
//        System.out.println(service == service2);

        //手动关闭容器
        ac.close();

    }
}
