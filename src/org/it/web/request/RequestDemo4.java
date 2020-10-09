package org.it.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/6 16:06
 */
@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 根据参数名称获取参数值
        //String name = request.getParameter("username");
        /*System.out.println("post");
        System.out.println(name);*/
        // 用于复选框
        /*String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("-------------------");*/

        // 获取所有请求的参数名称
        /*Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String hobbys = enumeration.nextElement();
            String value = request.getParameter(hobbys);
            System.out.println(hobbys + "----" + value);
            System.out.println("-------------------");
        }*/
        /*
        game
        study
        -------------------
        username----zhangsan
        -------------------
        pwd----Allen
        -------------------
        hobby----game
        -------------------
         */

        // 封装到集合里面
        Map<String, String[]> map = request.getParameterMap();
        // 遍历map，keySet
        Set<String> set = map.keySet();
        for (String name : set) {
            System.out.println(name);
            String[] values = map.get(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("-------------");
        }
        /*
        username
        zhangsan
        -------------
        pwd
        123456
        -------------
        hobby
        game
        study
        -------------
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 根据参数名称获取参数值，这几个方法对于get和post通用，所以说可以再调用post中的方法
        /*String name = request.getParameter("username");
        System.out.println("get");
        System.out.println(name);*/

        this.doPost(request, response);
    }
}
