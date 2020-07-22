package com.qwz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author  qlh
 * @date   2020/7/10
 * @desc
 * 时间转换工具类
 **/
public class DateUtils {

    private DateUtils() {
    }
    private static final String Time_type="yyyy-MM-dd";
    private static final String Time_type_second="yyyy-MM-dd HH:mm:ss";
    /**
     * @author  qlh
     * @date   2020/7/22
     * @desc
     * 将时间类型转换为字符串类型
     **/
    public static String Date2StringByType(Date date,String type){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(type);
        String format = simpleDateFormat.format(date);
        if(format!=null){
            return format;
        }
        return format;
    }

    /**
     * @author  qlh
     * @date   2020/7/22
     * @desc
     **/
    public static Date getCurrentDate(){
        return new Date();
    }



}
