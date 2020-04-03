package com.lgl.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lgl
 * @Description: 把字符串转换成日期
 * @date 2019/9/23 10:46 下午
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * @param s 传入进来的字符串
     * @return
     */
    @Override
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("传入的数据为null");
        }
        try {
            System.out.println("字符串转时间原数据: " + s);
            //定义格式
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = df.parse(s);
            System.out.println("转换成功: " + parse);
            return parse;
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换错误");
        }
    }
}
