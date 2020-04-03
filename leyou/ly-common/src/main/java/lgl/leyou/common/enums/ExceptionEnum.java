package lgl.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author lgl
 * @Description: 自定义异常的枚举
 * @date 2020/1/6 11:43 下午
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    CATEGORY_NOT_FOUND(404, "未查询到商品分类"),
    BRAND_NOT_FOUND(404, "未查询到品牌信息"),
    ;
    private int code;
    private String msg;
}
