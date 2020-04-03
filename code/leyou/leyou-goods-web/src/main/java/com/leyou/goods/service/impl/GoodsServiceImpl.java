package com.leyou.goods.service.impl;

import com.leyou.goods.client.BrandClient;
import com.leyou.goods.client.CategoryClient;
import com.leyou.goods.client.GoodsClient;
import com.leyou.goods.client.SpecificationClient;
import com.leyou.goods.service.IGoodsService;
import com.leyou.item.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author lgl
 * @Description: IGoodsService接口的实现类
 * @date 2020/2/27 10:29 下午
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private BrandClient brandClient;
    @Autowired
    private CategoryClient categoryClient;
    @Autowired
    private GoodsClient goodsClient;
    @Autowired
    private SpecificationClient specificationClient;

    @Override
    public Map<String, Object> loadData(Long spuId) {
        Map<String, Object> model = new HashMap<>();

        // 根据spuId查询Spu
        Spu spu = goodsClient.querySpuById(spuId);
        // 查询spuDetail
        SpuDetail spuDetail = goodsClient.querySpuDetailBySpuId(spuId);
        // 查询分类: Map<String,Object>
        List<Long> cids = Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3());
        List<String> names = categoryClient.queryNamesByIds(cids);
        // 初始化一个分类List
        List<Map<String, Object>> categories = new ArrayList<>();
        for (int i = 0; i < cids.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", cids.get(i));
            map.put("name", names.get(i));
            categories.add(map);
        }
        // 查询品牌
        Brand brand = brandClient.queryBrandById(spu.getBrandId());

        // 查询skus
        List<Sku> skus = goodsClient.querySkusBySpuId(spu.getId());

        // 查询规格参数组
        List<SpecGroup> groups = specificationClient.queryGroupsWithParam(spu.getCid3());

        // 查询特殊的规格参数
        List<SpecParam> params = specificationClient.querySpecParamByGid(null, spu.getCid3(), null, null);
        // 初始化特殊规格参数的map
        Map<Long, String> paramsMap = new HashMap<>();
        params.forEach(param -> {
            paramsMap.put(param.getId(), param.getName());
        });

        model.put("spu", spu);
        model.put("spuDetail", spuDetail);
        model.put("categories", categories);
        model.put("brand", brand);
        model.put("skus", skus);
        model.put("groups", groups);
        model.put("paramsMap", paramsMap);

        return model;
    }
}
