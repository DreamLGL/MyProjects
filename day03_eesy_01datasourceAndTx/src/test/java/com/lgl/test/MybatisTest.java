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
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("mybatis saveuser");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("保存操作之前:" + user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后" + user);
    }

    /**
     * 测试更新操作
     *
     * @throws Exception
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(49);
        user.setUserName("mybatis updateUser");
        user.setUserAddress("四川省成都市");
        user.setUserSex("女");
        user.setUserBirthday(new Date());
        //5.执行更新方法
        userDao.updateUser(user);

    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDelete() {
        Integer id = 49;
        //5.执行删除方法
        userDao.deleteUser(id);
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
     * 测试查询总记录条数
     */
    @Test
    public void testfindTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
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
}
