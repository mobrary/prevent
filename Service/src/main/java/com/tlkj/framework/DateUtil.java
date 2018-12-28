package com.tlkj.framework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyyMMddhhmmss = "yyyyMMddhhmmss";

    public static String getDayNum() {
        DateFormat sdf = new SimpleDateFormat(DateUtil.yyyyMMdd);
        return sdf.format(new Date());
    }

    public static String getDayNum(Date vDate) {
        DateFormat sdf = new SimpleDateFormat(DateUtil.yyyyMMdd);
        return sdf.format(vDate);
    }

    public static String getDayTimeNum() {
        DateFormat sdf = new SimpleDateFormat(DateUtil.yyyyMMddhhmmss);
        return sdf.format(new Date());
    }

    public static String getDayTimeNum(Date vDate) {
        DateFormat sdf = new SimpleDateFormat(DateUtil.yyyyMMddhhmmss);
        return sdf.format(vDate);
    }

    public static Date getDayTimeNum(String cDayTime) {
        SimpleDateFormat sdf = null;
        Date vDate = null;
        if (cDayTime.length() == 8) {
            sdf = new SimpleDateFormat(DateUtil.yyyyMMdd);
            //必须捕获异常
            try {
                vDate = sdf.parse(cDayTime);
            } catch (ParseException px) {
                px.printStackTrace();
            }
        } else if (cDayTime.length() == 14) {
            sdf = new SimpleDateFormat(DateUtil.yyyyMMddhhmmss);
            try {
                vDate = sdf.parse(cDayTime);
            } catch (ParseException px) {
                px.printStackTrace();
            }
        }
        return vDate;
    }
}
