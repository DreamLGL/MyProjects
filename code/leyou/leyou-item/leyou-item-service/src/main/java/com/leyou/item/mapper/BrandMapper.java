package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lgl
 * @Description: 品牌信息mapper
 * @date 2020/2/2 4:59 下午
 */
public interface BrandMapper extends Mapper<Brand> {
    /**
     * tb_category_brand 保存
     *
     * @param cid 分类id
     * @param bid 商品id
     */
    @Insert("insert into tb_category_brand (category_id,brand_id) values (#{cid},#{bid})")
    void insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 根据分类id(cid)查询品牌信息
     *
     * @param cid
     * @return
     */
    @Select("select tb.* from tb_brand tb inner join tb_category_brand tcb on tb.id = tcb.brand_id where category_id = #{cid}")
    List<Brand> selectBrandsByCid(Long cid);
}
