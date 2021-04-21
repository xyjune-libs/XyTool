package com.xyjune.tools;

import android.content.Context;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

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
        String title = "[ " + TimeUtil.getCurrentDateTime(TimeUtil.FORMAT_MILLIS_DATE) + " ]: ";
        dailyLog(path, alignMoreLines(title, log));
    }

    public static void dailyLog(String path, String content) {
        FileIOTool.appendFile(path, getDailyLogFilename(), content);
    }

    private static String getDailyLogFilename() {
        return TimeUtil.getCurrentDateString(TimeUtil.FORMAT_FILENAME_DATE) + ".log";
    }

    private static String alignMoreLines(String title, String log) {
        StringReader stringReader = new StringReader(log);
        BufferedReader reader = new BufferedReader(stringReader);
        StringWriter writer = new StringWriter();
        String line;
        int lineCount = 0;
        try {
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount == 1) {
                    writer.append(title);
                } else {
                    for (int i = 0; i < title.length(); i++) {
                        writer.append(" ");
                    }
                }
                writer.append(line).append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return writer.toString();
    }
}
