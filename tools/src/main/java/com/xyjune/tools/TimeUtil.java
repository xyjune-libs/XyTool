package com.xyjune.tools;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: 时间工具类
 * <BR/>
 * <BR/>
 * Author: xyJune <1107936000@qq.com><BR/>
 * Create at 2021/4/14<BR/>
 * (PS: Not easy to write code, please indicate)
 */
public class TimeUtil {

    public final static String FORMAT_DEFAULT_DATE = "yyyy-MM-dd HH:mm:ss";
    public final static String FORMAT_MILLIS_DATE = "yyyy-MM-dd HH:mm:ss:SSS";
    public final static String FORMAT_FILENAME_DATE = "yyyy_MM_dd_HH_mm_ss";

    /**
     * 获取当前时间戳
     *
     * @return ms(毫秒)
     */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前日期和时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDateTime() {
        return format(getCurrentTimeMillis(), FORMAT_DEFAULT_DATE);
    }

    /**
     * 根据pattern获取当前日期和时间
     *
     * @param pattern 格式，例：yyyy-MM-dd HH:mm:ss
     * @return pattern格式的日期时间
     */
    public static String getCurrentDateTime(String pattern) {
        return format(getCurrentTimeMillis(), pattern);
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Date getDateOfTimestamps(long timestamps) {
        return new Date(timestamps);
    }

    /**
     * 根据pattern格式化日期
     *
     * @param date    要格式的日期
     * @param pattern 格式，例：yyyy-MM-dd HH:mm:ss
     * @return pattern格式的日期时
     */
    public static String format(Date date, String pattern) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 根据pattern格式化时间戳
     *
     * @param timestamp 要格式的时间戳
     * @param pattern   格式，例：yyyy-MM-dd HH:mm:ss
     * @return pattern格式的日期时间
     */
    public static String format(long timestamp, String pattern) {
        return format(new Date(timestamp), pattern);
    }

}
