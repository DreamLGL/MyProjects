package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author lgl
 * @Description: CategroyService 实现类
 * @date 2019-08-21 23:13
 */
public class CategoryServiceImpl implements CategoryService {
    CategoryDao categroyDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //1.从redis中查询
        //1.1获取Jedis客户端
        Jedis jedis = JedisUtil.getJedis();
        //1.2可以所用sortedset排序查询
        Set<String> categorys = jedis.zrange("category", 0, -1);
        List<Category> all = null;
        //2.判断是否为空
        if (categorys == null || categorys.size() == 0) {
            //3.如果为空,需要从数据库查询,再将数据存入redis
            //3.1 从数据库查询数据
            System.out.println("从数据库中查询..........");
            all = categroyDao.findAll();
            //3.2 将集合数据存入redis中的 category的key
            for (int i = 0; i < all.size(); i++) {
                jedis.zadd("category", all.get(i).getCid(), all.get(i).getCname());
            }
        } else {
            //4.如果不为空,将set的数据存入list
            System.out.println("从redis中查询..........");
            all = new ArrayList<Category>();
            for (String name : categorys) {
                Category category = new Category();
                category.setCname(name);
                all.add(category);
            }
        }
        return all;
    }
}
