package com.lgl.test;

import com.lgl.dao.IUserDao;
import com.lgl.domain.QueryVo;
import com.lgl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lgl
 * @Description: 测试Mybatis的CRUD操作
 * @date 2019/11/6 12:14 上午
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     *
     * @throws Exception
     */
    @Test
    public void testFindAll() {
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void testFindById() {
        Integer id = 48;
        //5.执行删除方法
        User user = userDao.findById(id);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindByName() {
        //#
//        String name = "%王%";
        //$value写法
        String name = "王";
        List<User> users = userDao.findByName(name);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public  void testfindUserByVo(){
        User testuser = new User();
        testuser.setUserName("%王%");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(testuser);
        List<User> users = userDao.findUserByVo(queryVo);
        for (User user: users) {
            System.out.println(user);
        }
    }

    /**
     * 测试根据条件查询
     */
    @Test
    public void testfindUserByCondition(){
        User user = new User();
        user.setUserName("老王");
        user.setUserSex("女");
        //5.执行查询所有方法
        List<User> users = userDao.findUserByCondition(user);
        for (User user2 : users) {
            System.out.println(user2);
        }
    }

    /**
     * 测试foreach标签的使用
     */
    @Test
    public void testfindUserInIds(){
        QueryVo queryVo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);
        list.add(45);
        list.add(46);
        list.add(48);
        queryVo.setIds(list);
        //5.执行查询所有方法
        List<User> users = userDao.findUserInIds(queryVo);
        for (User user2 : users) {
            System.out.println(user2);
        }
    }
}
