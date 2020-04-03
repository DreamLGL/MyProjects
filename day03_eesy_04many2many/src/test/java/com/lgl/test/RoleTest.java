package com.lgl.test;

import com.lgl.dao.IRoleDao;
import com.lgl.dao.IUserDao;
import com.lgl.domain.Role;
import com.lgl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2019/11/22 12:00 上午
 */
public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IRoleDao roleDao;

    @Before//用于测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        roleDao = sqlSession.getMapper(IRoleDao.class);
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
     */
    @Test
    public void testfindAll() {
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("--------每个user的信息--------");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
