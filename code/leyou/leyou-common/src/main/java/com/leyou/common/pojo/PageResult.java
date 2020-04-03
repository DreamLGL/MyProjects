package com.leyou.common.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author lgl
 * @Description: 分页数据
 * @date 2020/2/2 9:00 下午
 */
@Data
public class PageResult<T> {
    private Long total;
    private Integer totalPage;
    private List<T> items;

    /**
     * 无参数构造方法
     */
    public PageResult() {

    }

    /**
     * 两参数构造方法
     *
     * @param total 数据条数
     * @param items 数据
     */
    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    /**
     * 全参数构造方法
     *
     * @param total     数据总条数
     * @param totalPage 总页数
     * @param items     数据
     */
    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }
}
