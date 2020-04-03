package com.lgl.mybatis.sqlsession;

import com.lgl.dao.IUserDao;

/**
 * @author lgl
 * @Description: 自定义MyBatis中和数据库交互的核心类,它里面可以创建dao接口的代理对象
 * @date 2019/11/4 11:08 下午
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);


    /**
     * 释放资源
     */
    void close();
}
