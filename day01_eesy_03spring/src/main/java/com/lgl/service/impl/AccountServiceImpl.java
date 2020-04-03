package com.lgl.service.impl;

import com.lgl.dao.AccountDao;
import com.lgl.dao.impl.AccountDaoImpl;
import com.lgl.service.IAccountService;

/**
 * @author lgl
 * @Description: 账户的业务层实现类
 * @date 2019-08-23 23:20
 */
public class AccountServiceImpl implements IAccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
