package com.lgl.service.impl;

import com.lgl.dao.IItemsDao;
import com.lgl.domain.Items;
import com.lgl.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lgl
 * @Description: IItemsService实现类
 * @date 2019/12/2 11:31 下午
 */
@Service
public class ItemsServiceImpl implements IItemsService {
    @Autowired
    private IItemsDao itemsDao;

    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }
}
