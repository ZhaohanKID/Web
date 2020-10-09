package org.it.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Cookie 快速入门
 * @Author: Z.HAN
 * @Date: 2020/10/7 12:42
 */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 创建 cookie 对象
        Cookie c = new Cookie("msg", "hello");
        // 可以发送多个cookie，只用创建多个cookie对象，发送多次即可
        Cookie cookie = new Cookie("name", "任嘉伦");
        response.addCookie(cookie);

        // 2 设置cookie存活时间
        //c.setMaxAge(60); // 1 将cookie持久化到硬盘 2 30s后自动删除该cookie文件

        // 2 发送 cookie
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
