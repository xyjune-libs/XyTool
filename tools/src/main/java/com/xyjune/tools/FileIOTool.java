package com.xyjune.tools;

import android.text.TextUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Description:
 * <BR/>
 * <BR/>
 * Author: xyJune <1107936000@qq.com><BR/>
 * Create at 2021/4/20<BR/>
 * (PS: Not easy to write code, please indicate)
 */
public class FileIOTool {

    /**
     * appendFile
     */
    public static boolean appendFile(File file, byte[] data) {
        return saveFile(file, data, true);
    }

    public static boolean appendFile(String path, String filename, String content) {
        return appendFile(path, filename, content.getBytes());
    }

    public static boolean appendFile(String path, String filename, byte[] data) {
        File file = createFile(path, filename);
        if (file == null) return false;
        return appendFile(file, data);
    }

    /**
     * saveFile
     */
    public static boolean saveFile(File file, byte[] data) {
        return saveFile(file, data, false);
    }

    public static boolean saveFile(String path, String filename, byte[] data) {
        File file = createFile(path, filename);
        if (file == null) return false;
        return saveFile(file, data);
    }

    public static boolean saveFile(String path, String filename, String content) {
        return saveFile(path, filename, content.getBytes());
    }

    public static boolean saveFile(File file, byte[] data, boolean isAppend) {
        if (file == null) return false;
        try {
            OutputStream outputStream = new FileOutputStream(file, isAppend);
            outputStream.write(data);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 创建文件
     *
     * @param path     文件路径
     * @param filename 文件名
     * @return 文件
     */
    public static File createFile(String path, String filename) {
        if (TextUtils.isEmpty(path) || TextUtils.isEmpty(filename)) {
            throw new IllegalArgumentException("path or filename is empty.");
        }
        File file = new File(path);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IllegalArgumentException("Can not mkdirs. Path=" + path);
            }
        }
        return new File(file, filename);
    }

}
