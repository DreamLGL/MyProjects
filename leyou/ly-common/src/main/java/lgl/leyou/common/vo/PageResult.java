package lgl.leyou.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @author lgl
 * @Description: 页面视图表格结果返回
 * @date 2020/1/9 11:31 下午
 */
@Data
public class PageResult<T> {
    //总条数
    private Long total;
    //总页数
    private Integer totalPage;
    //当前页面数据
    private List<T> items;

    public PageResult(){}

    public PageResult(Long total,List<T> items){
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }
}
