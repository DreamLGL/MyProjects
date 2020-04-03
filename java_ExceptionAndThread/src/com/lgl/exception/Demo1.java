package com.lgl.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lgl
 * @Description: 异常Demo1
 *      java.lang.Throwable:类是Java语言中所有错误或异常的超类.
 *          Exception:编译期异常,进行编译(写代码)Java程序出现的问题
 *              RuntimeException:运行期异常,Java程序运行过程中出现的问题
 *              异常就相当于程序得了一个小毛病(感冒,发烧),把异常处理掉,程序可以继续执行(吃点药,继续革命工作)
 *          Error:错误
 *              错误就相当于程序得了一个无法治愈的毛病(非典,艾滋),必须要修改源代码,程序才能继续执行
 * @date 2019-08-12 23:13
 */
public class Demo1 {
    public static void main(String[] args) {
        //Exception:编译期异常,进行编译(写代码)Java程序出现问题
        //用来格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse("1999-0909");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
    }
}
