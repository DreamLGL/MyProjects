package com.lgl.service;

/**
 * @author lgl
 * @Description: 账户的业务层接口
 * @date 2019/8/31 10:52 上午
 */
public interface AccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除账户
     * @return
     */
    int deleteAccount();
}
