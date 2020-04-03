package com.lgl.test;

import com.lgl.dao.IAccountDao;
import com.lgl.dao.IUserDao;
import com.lgl.domain.Account;
import com.lgl.domain.AccountUser;
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
 * @Description: Account测试类
 * @date 2019/11/18 11:34 下午
 */
public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before//用于测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
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
        List<Account> lists = accountDao.findAll();
        for (Account account : lists) {
            System.out.println("--------每个account的信息--------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 测试查询所有账户,同时包含用户名称和地址
     */
    @Test
    public void findAllAccount() {
        List<AccountUser> lists = accountDao.findAllAccount();
        for (AccountUser accountUser : lists) {
            System.out.println(accountUser);
        }
    }
}
