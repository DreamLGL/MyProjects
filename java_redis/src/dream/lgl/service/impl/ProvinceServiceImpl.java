package dream.lgl.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dream.lgl.dao.ProvinceDao;
import dream.lgl.dao.impl.ProvinceDaoImpl;
import dream.lgl.domain.Province;
import dream.lgl.jedis.uitl.JedisPoolUtils;
import dream.lgl.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    //1.申明dao
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        /**
         * 使用redis缓存
         */
        //现从Redis中查询数据
        //1.获取Redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        //2.判断 province_json数据是否为null
        if (province_json == null || province_json.length() == 0) {
            //redis中没有数据
            System.out.println("redis中没有数据,即将查询数据库数据");
            //2.1 从数据库中查询数据
            List<Province> list = dao.findAll();
            //2.2将list序列化成json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2,3 将json数据存入redis中
            jedis.set("province",province_json);
        }else{
            System.out.println("redis中有数据,直接使用");
        }
        return province_json;
    }
}
