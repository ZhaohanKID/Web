package org.it.web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/7 9:43
 */
@WebServlet("/ServletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // MIME类型：在互联网通信过程中定义的一种文件数据类型
        // 获取MIME类型
        ServletContext context = this.getServletContext();

        String filename = "img.jpg";
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType); // image/jpeg

        // 获取数据
        Object msg = context.getAttribute("msg");
        System.out.println(msg);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
