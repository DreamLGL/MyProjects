package com.lgl.service;

import com.lgl.domain.Items;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/2 11:29 下午
 */
public interface IItemsService {
    public Items findById(Integer id);
}
