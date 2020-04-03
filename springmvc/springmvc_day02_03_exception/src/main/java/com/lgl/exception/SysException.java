package com.lgl.exception;

/**
 * @author lgl
 * @Description: 自定义异常类
 * @date 2019/10/22 11:33 下午
 */
public class SysException extends Exception {
    //存储提示信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
