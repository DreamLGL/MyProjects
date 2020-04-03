package com.leyou.item.service;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;

import java.util.List;

/**
 * @author lgl
 * @Description: SpecificationService接口
 * @date 2020/2/6 10:49 下午
 */
public interface ISpecificationService {
    /**
     * 根据分类id查询参数组
     *
     * @param cid
     * @return
     */
    List<SpecGroup> querySpecGroupsByCid(long cid);

    /**
     * 根据组条件查询参数
     *
     * @param gid
     * @param cid
     * @param generic
     * @param searching
     * @return
     */
    List<SpecParam> querySpecParamByGid(Long gid, Long cid, Boolean generic, Boolean searching);

    /**
     * 根据cid查询组信息
     *
     * @param cid
     * @return
     */
    List<SpecGroup> queryGroupsWithParam(Long cid);
}
