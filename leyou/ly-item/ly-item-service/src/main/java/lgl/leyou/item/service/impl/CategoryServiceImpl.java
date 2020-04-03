package lgl.leyou.item.service.impl;

import lgl.leyou.common.enums.ExceptionEnum;
import lgl.leyou.common.exception.LyException;
import lgl.leyou.item.mapper.CategoryMapper;
import lgl.leyou.item.service.ICategoryService;
import lgl.leyou.ltem.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2020/1/8 12:51 上午
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryByPid(Long pid) {
        //查询条件,mapper会把对象中的非空属性作为查询条件
        Category category = new Category();
        category.setParentId(pid);
        List<Category> categoryList = categoryMapper.select(category);
        // 判断结果
        if(CollectionUtils.isEmpty(categoryList)){
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }else {
            return categoryList;
        }
    }
}
