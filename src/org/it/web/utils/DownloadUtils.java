package org.it.web.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/7 11:04
 */
public class DownloadUtils {
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE 浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}












