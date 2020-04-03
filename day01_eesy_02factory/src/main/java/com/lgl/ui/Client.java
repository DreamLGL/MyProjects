package com.lgl.ui;

import com.lgl.dao.AccountDao;
import com.lgl.factory.BeanFactory;
import com.lgl.service.IAccountService;
import com.lgl.service.impl.AccountServiceImpl;

/**
 * @author lgl
 * @Description: 模拟一个表现层, 用于调用业务层
 * @date 2019-08-23 23:29
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService service = new AccountServiceImpl();
        for(int i = 0;i<5;i++){
            IAccountService service = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(service);
            service.saveAccount();
        }

//        service.saveAccount();
    }
}
