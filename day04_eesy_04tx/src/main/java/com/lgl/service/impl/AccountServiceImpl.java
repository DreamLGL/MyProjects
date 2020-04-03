package com.lgl.service.impl;

import com.lgl.dao.IAccountDao;
import com.lgl.domain.Account;
import com.lgl.service.IAccountService;


import java.sql.SQLException;
import java.util.List;

/**
 * @author lgl
 * @Description: 账户业务层实现类
 * 事务控制应该都是在业务层
 * @date 2019/8/25 7:56 上午
 */
public class AccountServiceImpl implements IAccountService {
    IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }


    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer开始执行..........");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4转入账户价钱
        target.setMoney(target.getMoney() + money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
        //2.6更新转入账户
        accountDao.updateAccount(target);
    }

    public void test() {

    }
}
