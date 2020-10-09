package org.it.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Request对象获取请求行数据
 * @Author: Z.HAN
 * @Date: 2020/10/6 15:06
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求方式
        String method = request.getMethod();
        System.out.println(method);
        // 2 获取虚拟路径
        String cp = request.getContextPath();
        // 3 获取资源路径
        String sp = request.getServletPath();
        // 4 获取虚拟加资源路径
        String URI = request.getRequestURI();
        System.out.println(URI);
        // 5 获取HTTP版本号
        String http = request.getProtocol();
        // 6 获取访问机的IP地址
        String ip = request.getRemoteAddr();
        // 7 获取get方式请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);
    }
}
