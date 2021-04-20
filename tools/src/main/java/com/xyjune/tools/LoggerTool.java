package com.xyjune.tools;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;

/**
 * Description:
 * <BR/>
 * <BR/>
 * Author: xyJune <1107936000@qq.com><BR/>
 * Create at 2021/4/20<BR/>
 * (PS: Not easy to write code, please indicate)
 */
public class LoggerTool {

    public static void dailyLog(Context context, String dir, String log) {
        String path = context.getExternalFilesDir(null).getAbsolutePath();
        if (!TextUtils.isEmpty(dir)) {
            path += File.separator + dir;
        }
        dailyLog(path, "[ " + TimeUtil.getCurrentDateTime(TimeUtil.FORMAT_MILLIS_DATE) + " ]：" + log + "\r\n");
    }

    public static void dailyLog(String path, String content) {
        FileIOTool.appendFile(path, getDailyLogFilename(), content);
    }

    private static String getDailyLogFilename() {
        return TimeUtil.getCurrentDateString(TimeUtil.FORMAT_FILENAME_DATE) + ".log";
    }
}
