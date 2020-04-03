package com.lgl.ui;

import com.lgl.dao.AccountDao;
import com.lgl.service.IAccountService;
import com.lgl.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.security.cert.X509Certificate;

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
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as2 = (IAccountService) ac.getBean("accountService");
//        System.out.println(as);
//        AccountDao adao = (AccountDao) ac.getBean("accountDao");
//        System.out.println(adao);
//        System.out.println(as == as2);
        as.saveAccount();
        ac.close();
    }
}
