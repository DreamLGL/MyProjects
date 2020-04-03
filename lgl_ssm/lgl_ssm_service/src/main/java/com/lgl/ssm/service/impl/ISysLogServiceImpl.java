package com.lgl.ssm.service.impl;

import com.lgl.ssm.dao.ISysLogDao;
import com.lgl.ssm.domain.SysLog;
import com.lgl.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lgl
 * @Description: 日志接口实现类
 * @date 2019/12/19 11:55 下午
 */
@Service
@Transactional
public class ISysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}
