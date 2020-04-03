package com.lgl.dao;

import com.lgl.domain.Account;

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
     * 根据用户id查询账户信息
     * @param id
     * @return
     */
    List<Account> findAccountByUid(Integer id);

}
