package com.xyjune.tools;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Description:
 * <BR/>
 * <BR/>
 * Author: xyJune <1107936000@qq.com><BR/>
 * Create at 2021/4/21<BR/>
 * (PS: Not easy to write code, please indicate)
 */
public class LoggerToolTest extends TestCase {


    public void testLog() {
        int lineCount = 0;
        LinesWriter linesWriter = new LinesWriter();
        linesWriter.newLine("asoudfhoawhoifhn").newLine("asiugfiuawgibhfgbaobf").newLine("aisfuhiyawvuigvuiasbibfi");
        String title = "[ " + TimeUtil.getCurrentDateTime(TimeUtil.FORMAT_MILLIS_DATE) + " ]: ";
        StringReader stringReader = new StringReader(linesWriter.toString());
        BufferedReader reader = new BufferedReader(stringReader);
        StringWriter writer = new StringWriter();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount == 1) {
                    writer.append(title);
                } else {
                    for (int i = 0; i < title.getBytes().length; i++) {
                        writer.append(" ");
                    }
                }
                writer.append(line).append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(writer.toString());
    }
}