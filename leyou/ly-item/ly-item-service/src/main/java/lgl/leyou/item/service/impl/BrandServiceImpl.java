package lgl.leyou.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lgl.leyou.common.enums.ExceptionEnum;
import lgl.leyou.common.exception.LyException;
import lgl.leyou.common.vo.PageResult;
import lgl.leyou.item.mapper.BrandMapper;
import lgl.leyou.item.service.IBrandService;
import lgl.leyou.ltem.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lgl
 * @Description: 品牌service接口实现类
 * @date 2020/1/9 11:20 下午
 */
@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //分页
        PageHelper.startPage(page, rows);
        Example example = new Example(Brand.class);
        //过滤
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", "%" + key + "%").orEqualTo("letter", key.toUpperCase());
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            String sql = sortBy + (desc?" DESC":" ASC");
            example.setOrderByClause(sql);
        }
        //查询
        List<Brand> brandList = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brandList)) {
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        //解析分页结果
        PageInfo<Brand> brandPageInfo = new PageInfo<Brand>(brandList);
        PageResult<Brand> pageResult = new PageResult<Brand>((long) brandPageInfo.getTotal(), brandList);
        return pageResult;
    }
}
