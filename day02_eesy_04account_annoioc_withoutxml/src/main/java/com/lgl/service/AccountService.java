package com.lgl.service;

import com.lgl.domain.Account;

import java.util.List;

/**
 * @author lgl
 * @Description: 账户的业务层接口
 * @date 2019/8/25 7:48 上午
 */
public interface AccountService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询
     *
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     *
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     *
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     *
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
