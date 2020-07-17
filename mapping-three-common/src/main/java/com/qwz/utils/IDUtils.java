package com.qwz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/16 22:27
 */
public class IDUtils {
        public static  String getNum18(){
            String numStr = "" ;
            String headStr = "12";
            String trandStr = String.valueOf((Math.random() * 9 + 1)* 1000000);
            String dataStr = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
            numStr = trandStr.toString().substring(0, 2);
            numStr = headStr+numStr + dataStr ;
            return numStr ;
        }
}
