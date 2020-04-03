package cn.lgl.service.service.impl;

import cn.lgl.service.dao.IBrandDao;
import cn.lgl.service.pojo.Brand;
import cn.lgl.service.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lgl
 * @Description: service接口实现类
 * @date 2020/1/13 10:35 下午
 */
@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private IBrandDao brandDao;

    @Override
    public Brand queryUserByid(Long id) {
        return brandDao.selectByPrimaryKey(id);
    }
}
