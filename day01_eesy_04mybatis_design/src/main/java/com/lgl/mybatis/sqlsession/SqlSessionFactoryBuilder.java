package com.lgl.mybatis.sqlsession;

import com.lgl.mybatis.cfg.Configuration;
import com.lgl.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.lgl.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author lgl
 * @Description:用于创建一个SqlSessionFactory对象
 * @date 2019/11/4 11:03 下午
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的自己输入流来构建一个sqlSessionFactory工厂
     *
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
