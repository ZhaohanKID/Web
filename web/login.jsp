<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/7
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                var date = new Date().getTime();
                src = "/day15/CheckCodeServlet?time=" + date;
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="/day15/LoginTest">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img src="/day15/CheckCodeServlet" id="img"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
    <div><%=request.getSession().getAttribute("cc_error") == null ? "" : request.getSession().getAttribute("cc_error")%></div>
    <div><%=request.getSession().getAttribute("login_error") == null ? "" : request.getSession().getAttribute("login_error")%></div>
</body>
</html>
