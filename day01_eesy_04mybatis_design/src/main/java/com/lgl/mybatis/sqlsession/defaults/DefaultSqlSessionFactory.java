package com.lgl.mybatis.sqlsession.defaults;

import com.lgl.mybatis.cfg.Configuration;
import com.lgl.mybatis.sqlsession.SqlSession;
import com.lgl.mybatis.sqlsession.SqlSessionFactory;

/**
 * @author lgl
 * @Description: SqlSessionFactory接口的实现类
 * @date 2019/11/4 11:37 下午
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     *
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
