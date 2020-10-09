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
 * @Date: 2020/10/7 18:07
 */
@WebServlet("/LoginTest")
public class LoginTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 设置编码
        request.setCharacterEncoding("utf-8");
        // 2 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        // 3 获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        // 删除session中的验证码，保证每个验证码只能被使用一次
        session.removeAttribute("checkCode_session");
        // 4 要先判断验证码是否正确
        if (checkCode != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            // 验证码一致，需要比较用户名和密码
            if ("zhangsan".equals(username) && "123".equals(password)) {
                // 登录成功
                // 存储用户信息
                session.setAttribute("user", username);
                // 重定向到 success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                // 验证码不一致
                request.setAttribute("login_error", "用户名或密码错误");
                // 转发到登录页面
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            // 验证码不一致
            request.setAttribute("cc_error", "验证码错误");
            // 转发到登录页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
