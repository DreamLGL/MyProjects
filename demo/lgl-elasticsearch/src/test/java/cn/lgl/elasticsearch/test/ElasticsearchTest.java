package cn.lgl.elasticsearch.test;

import cn.lgl.elasticsearch.pojo.Item;
import cn.lgl.elasticsearch.repository.IItemRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author lgl
 * @Description: elasticsearch测试类
 * @date 2020/2/17 10:20 下午
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticsearchTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private IItemRepository iItemRepository;

    /**
     * 创建索引和映射
     */
    @Test
    public void testIndex() {
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(Item.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchTemplate.putMapping(Item.class);
    }

    /**
     * 删除索引
     */
    @Test
    public void deleteIndex() {
        elasticsearchTemplate.deleteIndex("leyou");
    }

    /**
     * 新增一条数据
     */
    @Test
    public void testCreate() {
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://upload.leyou.com/13123.jpg");
        // 新增一条数据
        iItemRepository.save(item);
    }

    /**
     * 批量新增数据
     */
    @Test
    public void testCreates() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://upload.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://upload.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://upload.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://upload.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://upload.leyou.com/13123.jpg"));
        // 批量新增数据
        iItemRepository.saveAll(list);
    }

    /**
     * 更新数据
     */
    @Test
    public void testUpdate() {
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3599.00, "http://upload.leyou.com/13123.jpg");
        // 更新数据,当id相同时保存就是更新
        iItemRepository.save(item);
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3599.00, "http://upload.leyou.com/13123.jpg");
        iItemRepository.delete(item);
    }

    /**
     * 根据ID查询
     */
    @Test
    public void testFindById() {
        Optional<Item> item = iItemRepository.findById(1l);
        System.out.println(item.get());
    }

    /**
     * 查询所有并排序
     */
    @Test
    public void testFindAll() {
        Iterable<Item> items = iItemRepository.findAll(Sort.by("price").descending());
        /*items.forEach(item -> {
            System.out.println(item);
        });*/
        items.forEach(System.out::println);
    }


    /**
     * 自定义方法:
     * 根据title查询
     */
    @Test
    public void testFindByTitle() {
        List<Item> items = iItemRepository.findByTitle("华为");
        items.forEach(System.out::println);
    }

    /**
     * 自定义方法:
     * 根据价格区间查询
     */
    @Test
    public void testFindByPriceBetween() {
        List<Item> items = iItemRepository.findByPriceBetween(3500d, 4000d);
        items.forEach(System.out::println);
    }

    /**
     * 高级查询:
     * 基本查询: QueryBuilders(查询构建器工具)
     */
    @Test
    public void testSearch() {
        // 通过查询构建器工具(QueryBuilders)构建查询条件
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", "手机");
        // 执行查询,获取结果集
        Iterable<Item> items = iItemRepository.search(queryBuilder);
        items.forEach(System.out::println);
    }

    /**
     * 高级查询:
     * 自定义查询: NativeSearchQueryBuilder() [以后工作中常用]
     */
    @Test
    public void testNativeSearch() {
        // 构架自定义查询器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的查询条件
        queryBuilder.withQuery(QueryBuilders.matchPhraseQuery("title", "手机"));
        // 执行查询获取分页结果集
        Page<Item> itemPage = iItemRepository.search(queryBuilder.build());
        System.out.println("TotalPages: " + itemPage.getTotalPages());
        System.out.println("TotalElements: " + itemPage.getTotalElements());
        itemPage.forEach(System.out::println);
        // 实际开发中一般使用的方式
        List<Item> items = itemPage.getContent();
        items.forEach(System.out::println);
    }

    /**
     * 高级查询:
     * 分页查询,排序查询
     */
    @Test
    public void testNativePageSearch() {
        // 构架自定义查询器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的查询条件
        queryBuilder.withQuery(QueryBuilders.matchPhraseQuery("category", "手机"));
        // 添加分页测试 PageRequest
        queryBuilder.withPageable(PageRequest.of(1, 2));
        // 添加排序 SortBuilders
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        // 执行查询获取分页结果集
        Page<Item> itemPage = iItemRepository.search(queryBuilder.build());
        // 实际开发中一般使用的方式
        List<Item> items = itemPage.getContent();
        items.forEach(System.out::println);
    }

    /**
     * 聚合
     */
    @Test
    public void testAggs() {
        // 初始化自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加聚合
        queryBuilder.addAggregation(AggregationBuilders.terms("brandAgg").field("brand"));
        // 添加结果集过滤,不包括任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));
        // 执行聚合查询
        AggregatedPage<Item> itemPage = (AggregatedPage<Item>) iItemRepository.search(queryBuilder.build());
        // 解析聚合结果集,根据聚合的类型已经字段的类型要进行墙砖,brand-是字符串类型的,聚合类型-词条聚合,brandAgg-通过聚合名称获取聚合对象
        StringTerms brandAgg = (StringTerms) itemPage.getAggregation("brandAgg");
        List<StringTerms.Bucket> buckets = brandAgg.getBuckets();
        buckets.forEach(bucket -> {
            System.out.println("key: " + bucket.getKeyAsString());
            System.out.println("docCount" + bucket.getDocCount());
        });
    }

    /**
     * 桶内度量
     */
    @Test
    public void testSubAggs() {
        // 初始化自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加聚合
        queryBuilder.addAggregation(AggregationBuilders.terms("brandAgg").field("brand").subAggregation(AggregationBuilders.avg("price_avg").field("price")));
        // 添加结果集过滤,不包括任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));
        // 执行聚合查询
        AggregatedPage<Item> itemPage = (AggregatedPage<Item>) iItemRepository.search(queryBuilder.build());
        // 解析聚合结果集,根据聚合的类型已经字段的类型要进行墙砖,brand-是字符串类型的,聚合类型-词条聚合,brandAgg-通过聚合名称获取聚合对象
        StringTerms brandAgg = (StringTerms) itemPage.getAggregation("brandAgg");
        List<StringTerms.Bucket> buckets = brandAgg.getBuckets();
        buckets.forEach(bucket -> {
            System.out.println("key: " + bucket.getKeyAsString());
            System.out.println("docCount: " + bucket.getDocCount());
            // 获取子聚合的map集合:key-聚合名称,value-对应的子聚合对象
            Map<String, Aggregation> stringAggregationMap = bucket.getAggregations().asMap();
            InternalAvg price_avg = (InternalAvg) stringAggregationMap.get("price_avg");
            System.out.println("price_avg: " + price_avg.getValue());
        });
    }
}
