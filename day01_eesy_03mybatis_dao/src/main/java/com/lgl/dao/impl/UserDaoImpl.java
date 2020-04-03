package com.lgl.dao.impl;

import com.lgl.dao.IUserDao;
import com.lgl.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author lgl
 * @Description: IUserDao实现类
 * @date 2019/10/24 11:44 下午
 */
public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //1.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询所有方法
        List<User> users = session.selectList("com.lgl.dao.IUserDao.findAll");
        session.close();
        return users;
    }
}
