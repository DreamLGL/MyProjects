package com.lgl.dao.impl;

import com.lgl.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author lgl
 * @Description: 账户持久层的实现类
 * @date 2019-08-23 23:25
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    public void saveAccount() {
        System.out.println("保存了账户22222222222222");
    }
}
