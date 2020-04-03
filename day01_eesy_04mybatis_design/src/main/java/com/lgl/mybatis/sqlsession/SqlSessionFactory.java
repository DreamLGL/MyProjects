package com.lgl.mybatis.sqlsession;

/**
 * @author lgl
 * @Description:
 * @date 2019/11/4 11:05 下午
 */
public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
