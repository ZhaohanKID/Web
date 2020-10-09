package org.it.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/7 15:35
 */
@WebServlet("/SessionDemo2")
public class SessionDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用session获取数据
        // 获取session
        HttpSession session = request.getSession();
        // 2 获取数据
        Object msg = session.getAttribute("msg");
        System.out.println(msg);
        /*
        这里访问是对的：
        hello session

         */



        /*
        为啥把头返回了？？访问cookie的
            LastTime---2020%E5%B9%B410%E6%9C%8807%E6%97%A515%3A30%3A42
            JSESSIONID---8EC883878B5A76740160E2C9467B84AC
            Idea-ec12eb5b---4c1b390e-e520-41d0-a317-2d9c87c61883
            __guid---111872281.3082708117376469500.1582260356395.798
            Webstorm-3392fb18---039f7b64-378f-41b8-a7eb-a5f0a9d1432e
            monitor_count---81
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
