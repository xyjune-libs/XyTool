package com.xyjune.tools;

/**
 * Description:
 * <BR/>
 * <BR/>
 * Author: xyJune <1107936000@qq.com><BR/>
 * Create at 2021/4/21<BR/>
 * (PS: Not easy to write code, please indicate)
 */
public final class LinesWriter {

    private final StringBuffer buf;
    private final Object lock;

    public LinesWriter() {
        buf = new StringBuffer();
        lock = buf;
    }

    public LinesWriter append(String str, int off, int len) {
        synchronized (lock) {
            if (str == null) {
                str = "null";
                off = 0;
                len = str.length();
            }
            buf.append(str, off, len);
        }
        return this;
    }

    public LinesWriter append(String str) {
        if (str == null) str = "null";
        return append(str, 0, str.length());
    }

    public LinesWriter newLine(String lineStr, int off, int len) {
        if (buf.length() > 0) append("\r\n");
        return append(lineStr, off, len);
    }

    public LinesWriter newLine(String lineStr) {
        if (buf.length() > 0) append("\r\n");
        return append(lineStr);
    }


    public String toString() {
        return buf.toString();
    }

    public StringBuffer getBuffer() {
        return buf;
    }
}
