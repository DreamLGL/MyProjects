package com.lgl.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lgl
 * @Description: 日期转换工具类
 * @date 2019/12/11 1:23 上午
 */
public class DateUtils {
    /**
     * 日期转换成字符串
     * @param date
     * @param patt
     * @return
     */
    public static String dateToString(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    /**
     * 字符串转换成日期
     * @param str
     * @param patt
     * @return
     */
    public static Date stringToDate(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
}
