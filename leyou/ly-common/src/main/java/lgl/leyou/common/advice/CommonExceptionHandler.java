package lgl.leyou.common.advice;

import lgl.leyou.common.enums.ExceptionEnum;
import lgl.leyou.common.exception.LyException;
import lgl.leyou.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lgl
 * @Description: 通用统一异常拦截处理器
 * @date 2020/1/6 11:24 下午
 */

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(LyException.class)
    public ResponseEntity<ExceptionResult> handleException(LyException e) {
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getCode()).body(new ExceptionResult(exceptionEnum));
    }
}
