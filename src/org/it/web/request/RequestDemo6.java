package org.it.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/6 16:06
 */
@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo6 被访问了");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 根据参数名称获取参数值，这几个方法对于get和post通用，所以说可以再调用post中的方法
        /*String name = request.getParameter("username");
        System.out.println("get");
        System.out.println(name);*/

        System.out.println(request.getAttribute("msg"));

        this.doPost(request, response);
    }
}
