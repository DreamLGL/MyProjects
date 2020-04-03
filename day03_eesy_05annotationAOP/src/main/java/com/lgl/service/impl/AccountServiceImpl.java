package com.lgl.service.impl;

import com.lgl.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author lgl
 * @Description: 账户的业务实现类
 * @date 2019/8/31 10:56 上午
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行了保存.........");
//        int i=1/0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新.........");

    }

    public int deleteAccount() {
        System.out.println("执行了删除.........");
        return 0;
    }
}
