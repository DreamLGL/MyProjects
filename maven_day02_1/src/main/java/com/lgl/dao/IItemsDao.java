package com.lgl.dao;

import com.lgl.domain.Items;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/1 11:58 下午
 */
public interface IItemsDao {
    Items findById(Integer id);
}
