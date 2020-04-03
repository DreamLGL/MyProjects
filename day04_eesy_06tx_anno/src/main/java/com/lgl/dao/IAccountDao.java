package com.lgl.dao;

import com.lgl.domain.Account;

/**
 * @author lgl
 * @Description:账户的持久层接口
 * @date 2019/9/17 10:43 下午
 */
public interface IAccountDao {
    /**
     * 根据Id查询账户
     *
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据姓名查询账户
     *
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 跟新账户
     * @param account
     */
    void updateAccount(Account account);
}
