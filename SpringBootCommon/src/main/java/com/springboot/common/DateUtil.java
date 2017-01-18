package com.springboot.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Title: 日期工具类
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/6 0006.
 */
public class DateUtil {

    public  static SimpleDateFormat simpleDateFormat;

    public static String getFormatDateStr(String format, Date date) {
        if (date == null) {
            return null;
        }
        simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 按照什么格式来解析字符串类型的时间
     *
     * @param format
     * @param dateStr
     * @return
     */
    public static Date getFormatDate(String format, String dateStr) {
        simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date = simpleDateFormat.parse(dateStr);
            return date;
        } catch (ParseException parse) {
            return null;
        }
    }

    public static int daysBetween(String format, String smdate, String bdate) {
        if(format == null || smdate ==  null || bdate == null){
            return 0;
        }
        simpleDateFormat = new SimpleDateFormat(format);
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(simpleDateFormat.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(simpleDateFormat.parse(bdate));
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(getFormatDateStr(Constants.DATE_FORMAT_1, null));
        System.out.println(getFormatDateStr(Constants.DATE_FORMAT_2, new Date()));
        Date date = new Date();

        System.out.println(getFormatDate(Constants.DATE_FORMAT_2, "2016-01-01"));
        System.out.println(getFormatDate(Constants.DATE_FORMAT_3, "2016年01月1日"));
        System.out.println(daysBetween(Constants.DATE_FORMAT_2,null, ""));
    }

}
