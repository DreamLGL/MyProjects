package com.lgl.factory;

import com.lgl.service.IAccountService;
import com.lgl.service.impl.AccountServiceImpl;

/**
 * @author lgl
 * @Description: 模拟一个工厂类(该类可能存在于jar包中的, 我们无法通过修改源码的方式来提供默认构造函数)
 * @date 2019-08-24 09:47
 */
public class InstanceFactory {
    public  IAccountService getAccountService(){
        return  new AccountServiceImpl();
    }
}
