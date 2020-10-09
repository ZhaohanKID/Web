package org.it.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/7 14:05
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的消息体的数据格式及编码
        response.setContentType("text/html;charset=utf-8");

        // 判断是否有cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("LastTime".equals(name)) {
                    flag = true;
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间是：" + value + "<h1>");

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
                    String time = sdf.format(date);
                    System.out.println("编码前：" + time);
                    time = URLEncoder.encode(time, "utf-8");
                    System.out.println("编码后：" + time);
                    // 设置存活时间
                    cookie.setMaxAge(60 * 60 * 24);
                    cookie.setValue(time);
                    response.addCookie(cookie);
                }
            }
        }
        if (cookies == null || cookies.length == 0 || flag == false) {
            response.getWriter().write("<h1>您好，欢迎首次访问<h2>");
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String time = sdf.format(date);
            System.out.println("编码前：" + time);
            time = URLEncoder.encode(time, "utf-8");
            System.out.println("编码后：" + time);
            Cookie cookie = new Cookie("LastTime", time);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
        }
        /*
        首次访问：
            编码前：2020年10月07日 14:27:37
            编码后：2020%E5%B9%B410%E6%9C%8807%E6%97%A5+14%3A27%3A37

        后来的访问：
            解码前：2020%E5%B9%B410%E6%9C%8807%E6%97%A5+14%3A27%3A37
            解码后：2020年10月07日 14:27:37
            编码前：2020年10月07日14:28:01
            编码后：2020%E5%B9%B410%E6%9C%8807%E6%97%A514%3A28%3A01
            解码前：2020%E5%B9%B410%E6%9C%8807%E6%97%A514%3A28%3A01
            解码后：2020年10月07日14:28:01
            编码前：2020年10月07日14:28:45
            编码后：2020%E5%B9%B410%E6%9C%8807%E6%97%A514%3A28%3A45
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
