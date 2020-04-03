package com.lgl.dao;

import com.lgl.domain.Account;
import com.lgl.domain.AccountUser;

import java.util.List;

/**
 * @author lgl
 * @Description: Account的接口
 * @date 2019/11/18 11:27 下午
 */
public interface IAccountDao {
    /**
     * 查询所有账户,同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户,并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
