package com.oil.framework.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 获取当前时间差的格式化描述
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename:  RelativeDateFormat.java
 * @PackageName: com.aikxian.framework.common.uitl
 * @Author: zhaopeng 赵鹏
 * @Email: zhaopeng@aikxian.com
 * @Date:2016年9月9日下午1:11:30
 * @Copyright (c) 2016, dev@aikxian.com All Rights Reserved.
 * @Description
 */
public class RelativeDateFormat {

    private static final long       ONE_MINUTE     = 60000L;
    private static final long       ONE_HOUR       = 60L * ONE_MINUTE;
    private static final long       ONE_DAY        = 24L * ONE_HOUR;
    private static final long       ONE_WEEK       = 7L * ONE_DAY;
    private static final long       ONE_MONTH      = 30L * ONE_DAY;
    private static final long       ONE_YEAR       = 365L * ONE_DAY;

    private static final String     ONE_SECOND_AGO = "秒前";
    private static final String     ONE_MINUTE_AGO = "分钟前";
    private static final String     ONE_HOUR_AGO   = "小时前";
    private static final String     ONE_DAY_AGO    = "天前";
    private static final String     ONE_MONTH_AGO  = "月前";
    private static final String     ONE_YEAR_AGO   = "年前";

    private static SimpleDateFormat format         = new SimpleDateFormat("MM-dd HH:mm");

    public static void main(String[] args) throws ParseException {

    }

    /***
     * 输入时间戳可获取距离当前时间差
     * @param time
     * @return
     */
    public static String format(long time) {
        long delta = System.currentTimeMillis() - time;
        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
        }
        if (delta < 60L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (delta < 48L * ONE_HOUR) {
            return "昨天";
        }
        if (delta < ONE_WEEK) {
            long days = toDays(delta);
            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
        }
        if (delta < ONE_YEAR) {
            return format.format(new Date(time));
        } else {
            return new Date(time).toLocaleString();
        }
        //        if (delta < 12L * 4L * ONE_WEEK) {
        //            long months = toMonths(delta);
        //            return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
        //        } else {
        //            long years = toYears(delta);
        //            return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
        //        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 12L;
    }

}
