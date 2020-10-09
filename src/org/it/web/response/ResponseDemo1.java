package org.it.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  重定向
 * @Author: Z.HAN
 * @Date: 2020/10/6 20:00
 */
@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseDemo1 被访问了。。。");

        // 访问/ResponseDemo1，会自动跳转到ResponseDemo2
        // 1 设置状态码为302
        response.setStatus(302);
        // 2 设置响应头 location
        response.setHeader("location", "/ResponseDemo2");


        // 简单的重定向
        // 动态获取虚拟路径
        String path = request.getContextPath();
        response.sendRedirect(path + "/ResponseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
