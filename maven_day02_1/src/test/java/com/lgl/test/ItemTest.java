package com.lgl.test;

import com.lgl.dao.IItemsDao;
import com.lgl.domain.Items;
import com.lgl.service.IItemsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/2 12:23 上午
 */
public class ItemTest {
    private ApplicationContext ac;
    private IItemsDao itemsDao;
    private IItemsService itemsService;

    @Before
    public void init(){
        //获取Spring容器
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中拿到所需要的dao的代理对象
        itemsDao = ac.getBean(IItemsDao.class);
        //从容器中拿到所需要的service的代理对象
        itemsService = ac.getBean(IItemsService.class);
    }

    /**
     * dao测试
     */
    @Test
    public void daoTestFindById(){
        Integer id = 1;
        Items items = itemsDao.findById(id);
        System.out.println(items);
    }

    /**
     * service测试
     */
    @Test
    public void serviceTestFindById(){
        Integer id = 1;
        Items items = itemsService.findById(id);
        System.out.println(items);

    }
}
