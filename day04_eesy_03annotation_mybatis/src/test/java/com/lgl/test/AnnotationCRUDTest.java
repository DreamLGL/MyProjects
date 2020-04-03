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
import java.util.Date;
import java.util.List;

/**
 * @author lgl
 * @Description: 注解CRUD操作测试
 * @date 2019/11/26 11:00 下午
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("测试注解保存");
        user.setSex("男");
        user.setAddress("测试地址");
        user.setBirthday(new Date());
        userDao.saveUser(user);
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(54);
        user.setUsername("测试注解更新");
        user.setSex("男");
        user.setAddress("测试地址");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    /**
     * 测试删除
     */
    @Test
    public void testDeleteUserById() {
        Integer id = 53;
        userDao.deleteUserById(id);
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void testFindUserById() {
        Integer id = 54;
        User user = userDao.findUserById(id);
        System.out.println(user);
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void findUserByName() {
//        String username = "%王%";
        String username = "王";
        List<User> users = userDao.findUserByName(username);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总数
     */
    @Test
    public void findTotalUser() {
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser);
    }

}
