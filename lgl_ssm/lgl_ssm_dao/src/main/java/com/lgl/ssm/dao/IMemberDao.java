package com.lgl.ssm.dao;

import com.lgl.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author lgl
 * @Description: 成员的Dao
 * @date 2019/12/14 10:16 下午
 */
public interface IMemberDao {
    /**
     * 根据id查询menber
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id = #{id}")
    public Member findById(String id) throws Exception;
}
