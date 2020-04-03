package com.lgl.ssm.service;

import com.lgl.ssm.domain.SysLog;

import java.util.List;

/**
 * @author lgl
 * @Description: 日志的Service接口
 * @date 2019/12/19 11:53 下午
 */
public interface ISysLogService {
    /**
     * 查询所有日志
     * @return
     * @throws Exception
     */
    public List<SysLog> findAll() throws Exception;

    /**
     * 保存日志
     * @param sysLog
     * @throws Exception
     */
    public void save(SysLog sysLog) throws Exception;
}
