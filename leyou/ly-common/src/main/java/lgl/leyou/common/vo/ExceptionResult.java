package lgl.leyou.common.vo;

import lgl.leyou.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @author lgl
 * @Description: 异常结果
 * @date 2020/1/6 11:54 下午
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;


    public ExceptionResult(ExceptionEnum em){
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
