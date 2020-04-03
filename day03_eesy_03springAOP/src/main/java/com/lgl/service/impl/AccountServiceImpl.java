package com.lgl.service.impl;

import com.lgl.service.AccountService;

/**
 * @author lgl
 * @Description: 账户的业务实现类
 * @date 2019/8/31 10:56 上午
 */
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行了保存.........");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新.........");

    }

    public int deleteAccount() {
        System.out.println("执行了删除.........");
        return 0;
    }
}
