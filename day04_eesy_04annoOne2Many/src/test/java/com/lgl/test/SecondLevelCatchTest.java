package com.lgl.test;

import com.lgl.dao.IUserDao;
import com.lgl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lgl
 * @Description: 二级缓存注解测试
 * @date 2019/11/27 11:33 下午
 */
public class SecondLevelCatchTest {

    private InputStream in;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After
    public void destroy() throws IOException {

        in.close();
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void testFindUserById() {
        SqlSession sqlSession = factory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);;
        Integer id = 54;
        User user = userDao.findUserById(id);
        System.out.println(user);

        sqlSession.close();//释放一级缓存

        SqlSession sqlSession1 = factory.openSession();
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user2 = userDao1.findUserById(id);
        System.out.println(user2);
        sqlSession1.close();
    }
}
