package com.lgl.utils;

/**
 * @author lgl
 * @Description: 用于记录日志的工具类, 它里面提供了公共的代码
 * @date 2019/8/31 10:58 上午
 */
public class Logger {
    /**
     * 用于打印日志,计划让其在切入点方法执行之前执行(切入点方法就是业务层方法)
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法开始记录日志了......");
    }
}
