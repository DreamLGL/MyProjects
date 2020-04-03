package cn.lgl.service.service;

import cn.lgl.service.pojo.Brand;

/**
 * @author lgl
 * @Description: service层接口
 * @date 2020/1/13 10:35 下午
 */
public interface IBrandService {
    /**
     * 根据Id查询
     * @param id
     * @return
     */
    Brand queryUserByid(Long id);
}
