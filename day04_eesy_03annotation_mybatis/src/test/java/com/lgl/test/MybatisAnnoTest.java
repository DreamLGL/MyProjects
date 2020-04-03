package com.lgl.test;

import com.lgl.dao.IUserDao;
import com.lgl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lgl
 * @Description: 注解测试
 * @date 2019/11/25 11:58 下午
 */
public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1.获取自己输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据字节流获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.根据SqlSessionFactory生产一个SqlSession
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession获取dao的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5.执行dao方法
        List<User> users = userDao.findAll();
        for (User user:users) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
