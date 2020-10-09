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
 * @Date: 2020/10/7 9:39
 */
@WebServlet("/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取servletContext对象有两种方式
        /*
            servletContext 的功能：
                1 获取MIME类型
                2 域对象：共享数据
                3 获取文件真实的服务器路径
         */
        ServletContext context1 = req.getServletContext();
        ServletContext context2 = this.getServletContext();
        System.out.println(context1);
        System.out.println(context2);
        System.out.println(context1 == context2);
        /*
            org.apache.catalina.core.ApplicationContextFacade@407634a8
            org.apache.catalina.core.ApplicationContextFacade@407634a8
            true
                 */


        /*
            作用域也很大
            context 对象的生命周期很长，从服务器开启就存在，到服务器结束才消失
            所以如果才服务器中按照这样的方式存储太多这样的数据，
            会造成服务器压力很大
         */
        context1.setAttribute("msg" , "haha");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
