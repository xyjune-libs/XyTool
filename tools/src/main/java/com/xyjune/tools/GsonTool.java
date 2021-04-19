package com.xyjune.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Description: GSON辅助工具
 * <BR/>
 * <BR/>
 * Author: xyJune <1107936000@qq.com><BR/>
 * Create at 2021/4/19<BR/>
 * (PS: Not easy to write code, please indicate)
 */
public class GsonTool {

    public static final Gson GSON_DEF = new GsonBuilder().create();
    public static final Gson GSON_WITHOUT_EXPO = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    public static final Gson GSON_SERIAL_NULLS = new GsonBuilder().serializeNulls().create();
    public static final Gson GSON_LOGGER = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting()
            .serializeNulls().setDateFormat(TimeUtil.FORMAT_MILLIS_DATE).create();

    /**
     * 使用默认的Gson实例{@link #GSON_DEF}转成Json字符串
     *
     * @param object 需要转成Json字符串的对象
     * @return Json字符串
     */
    public static String toJson(Object object) {
        return toJson(object, GSON_DEF);
    }

    /**
     * 可选择已构建好的Gson实例：{@link #GSON_DEF}、{@link #GSON_WITHOUT_EXPO}、{@link #GSON_SERIAL_NULLS}、{@link #GSON_LOGGER}<BR/>
     * 也可使用自己构建的Gson实例。
     *
     * @param object 需要转成Json字符串的对象
     * @param gson   Gson实例
     * @return Json字符串
     */
    public static String toJson(Object object, Gson gson) {
        return gson.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> tClass) {
        return fromJson(json, tClass, GSON_DEF);
    }

    public static <T> T fromJson(String json, Class<T> tClass, Gson gson) {
        return gson.fromJson(json, tClass);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return fromJson(json, typeOfT, GSON_DEF);
    }

    public static <T> T fromJson(String json, Type typeOfT, Gson gson) {
        return gson.fromJson(json, typeOfT);
    }
}
