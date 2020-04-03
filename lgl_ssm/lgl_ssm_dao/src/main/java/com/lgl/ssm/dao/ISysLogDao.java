package com.lgl.ssm.dao;

import com.lgl.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lgl
 * @Description: 日志数据库操作接口
 * @date 2019/12/19 11:56 下午
 */
public interface ISysLogDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;

    /**
     * 保存日志
     * @param sysLog
     */
    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method) values (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;
}
