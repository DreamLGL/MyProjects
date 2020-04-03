package com.lgl.dao.impl;

import com.lgl.dao.IUserDao;
import com.lgl.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2019/11/11 11:11 下午
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //1.根据factory获取SqlSession对像
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法,实现列表查询
        List<User> users = session.selectList("com.lgl.dao.IUserDao.findAll");//参数就是能获取配置信息的key
        //3.释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        //1.根据factory获取SqlSession对像
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法,实现列表查询
        session.insert("com.lgl.dao.IUserDao.saveUser", user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();

    }

    public void updateUser(User user) {
        //1.根据factory获取SqlSession对像
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法,实现列表查询
        session.update("com.lgl.dao.IUserDao.updateUser", user);
        session.commit();
        session.close();

    }

    public void deleteUser(Integer userId) {
        //1.根据factory获取SqlSession对像
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法,实现列表查询
        session.delete("com.lgl.dao.IUserDao.deleteUser", userId);
        session.commit();
        session.close();
    }

    public User findById(Integer id) {
        //1.根据factory获取SqlSession对像
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法,实现列表查询
        User user = session.selectOne("com.lgl.dao.IUserDao.findById", id);
        session.commit();
        return user;
    }

    public List<User> findByName(String name) {
        //1.根据factory获取SqlSession对像
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法,实现列表查询
        List<User> users = session.selectList("com.lgl.dao.IUserDao.findByName", name);
        session.commit();
        return users;
    }

    public int findTotal() {
        //1.根据factory获取SqlSession对像
        SqlSession session = factory.openSession();
        Integer total = session.selectOne("com.lgl.dao.IUserDao.findTotal");
        return total;
    }
}
