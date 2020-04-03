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
     * 获取spring的ioc核心容器,并根据id获取对象
     * ApplicationContext的三个常用实现类.
     *      ClassPathXMLApplicationContext: 它可以加载类路径下的配置文件,要求配置文件必须要在类路径下.不在的话,加载不了(更常用)
     *      FileSystemXMLApplicationContext: 它可以加载磁盘任意路径下的配置文件(必须有访问权限)
     *
     *      AnnotationConfigApplicationContext: 它是用于读取注解创建容器
     * 核心容器的两个接口引发出的问题
     *  ApplicationContext: 单例对象适用
     *      它在构建核心容器时,创建对象采取的策略是采用立即加载的方式,也就是说,只要已读取完配置文件马上就创建配置文件中配置的对象
     *  BeanFactory: 多例对象适用
     *      它在构建核心容器时,创建对象采取的策略是采用延迟加载的方式,也就是说,什么时候根据id获取对象,什么时候才真正的创建对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//推荐方式
//        ApplicationContext ac = new FileSystemXmlApplicationContext("//Users/WorkSpace/day01_eesy_03spring/src/main/resources/bean.xml");
        //2.根据id获取Bean对象
//        IAccountService service = (IAccountService) ac.getBean("accountService");
//        AccountDao dao = (AccountDao) ac.getBean("accountDao");
//        System.out.println(service);
//        System.out.println(dao);
//        service.saveAccount();


        //---------BeanFactory----------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService service = (IAccountService) factory.getBean("accountService");
        System.out.println(service);
    }
}
