package com.lgl.test;

import com.lgl.dao.IUserDao;
import com.lgl.dao.impl.UserDaoImpl;
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
    private IUserDao userDao;

    @Before//用于测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂对象创建dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After//用于测试方法执行之后执行
    public void destroy() throws Exception {
        //6.释放资源
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
        user.setUsername("mybatis saveuser");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
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
        user.setId(50);
        user.setUsername("mybatis updateUser");
        user.setAddress("四川省成都市");
        user.setSex("女");
        user.setBirthday(new Date());
        //5.执行更新方法
        userDao.updateUser(user);

    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDelete() {
        Integer id = 50;
        //5.执行删除方法
        userDao.deleteUser(id);
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void testFindById() {
        Integer id = 51;
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
}
