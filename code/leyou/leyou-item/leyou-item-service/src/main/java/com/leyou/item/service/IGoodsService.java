package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;

import java.util.List;

/**
 * @author lgl
 * @Description: 商品列表service接口
 * @date 2020/2/12 4:59 下午
 */
public interface IGoodsService {
    /**
     * 根据条件分页查询spu
     *
     * @param key
     * @param saleable
     * @param page
     * @param rows
     * @return
     */
    PageResult<SpuBo> querySpuByPage(String key, Boolean saleable, Integer page, Integer rows);

    /**
     * 根据参数新增商品
     *
     * @param spuBo
     */
    void saveGoods(SpuBo spuBo);

    /**
     * 新增Sku和Stock
     *
     * @param spuBo
     */
    void saveSkuAndStock(SpuBo spuBo);

    /**
     * 跟前spuId查询spu的详细信息
     *
     * @param spuId
     * @return
     */
    SpuDetail querySpuDetailBySpuId(Long spuId);

    /**
     * 根据Id查询skus
     *
     * @param spuId
     * @return
     */
    List<Sku> querySkusBySpuId(Long spuId);

    /**
     * 根据参数修改商品信息
     *
     * @param spuBo
     */
    void updateGoods(SpuBo spuBo);

    /**
     * 根据id查询Spu
     *
     * @param id
     * @return
     */
    Spu querySpuById(Long id);

    /**
     * 根据skuId 查询sku
     *
     * @param skuId
     * @return
     */
    Sku querySkuById(Long skuId);
}
