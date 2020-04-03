package com.lgl.test;

import com.lgl.dao.IUserDao;
import com.lgl.domain.User;
import com.lgl.mybatis.io.Resources;
import com.lgl.mybatis.sqlsession.SqlSession;
import com.lgl.mybatis.sqlsession.SqlSessionFactory;
import com.lgl.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lgl
 * @Description: Mybatis测试
 * @date 2019/10/24 10:25 下午
 */
public class MybatisTest {
    /**
     * 入门案例
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users
        ) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
