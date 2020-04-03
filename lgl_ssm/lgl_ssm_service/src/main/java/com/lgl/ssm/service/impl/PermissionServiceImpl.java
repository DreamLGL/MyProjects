package com.lgl.ssm.service.impl;

import com.lgl.ssm.dao.IPermissionDao;
import com.lgl.ssm.domain.Permission;
import com.lgl.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lgl
 * @Description: PermissionService的实现类
 * @date 2019/12/17 11:09 下午
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void savePermission(Permission permission) throws Exception {
        permissionDao.savePermission(permission);
    }
}
