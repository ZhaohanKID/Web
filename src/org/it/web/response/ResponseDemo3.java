package org.it.web.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/6 21:23
 */
@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 首先要改变编码集
        response.setContentType("text/html;charset=utf-8");

        // 1 获取字符输出流对象
        /*PrintWriter pw = response.getWriter();
        // 2 输出
        pw.write("你好啊！response");*/

        // 字节流
        ServletOutputStream sos = response.getOutputStream();
        sos.write("你好".getBytes());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
