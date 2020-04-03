package com.lgl.service.impl;

import com.lgl.service.IAccountService;

import java.util.Date;

/**
 * @author lgl
 * @Description: 账户的业务层实现类
 * @date 2019-08-23 23:20
 */
public class AccountServiceImpl implements IAccountService {
    //如果是经常变化的数据并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了..." + name + "," + age + "," + birthday);
    }

}
