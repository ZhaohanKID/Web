<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/6
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  JSP的内置对象
  request
  response
  out

  jsp中的out对象是JspWriter类型的．
  而JspWriter继承了java.io.Writer .
  write方法是在在父类Writer中定义的，
  print方法是在子类JspWriter中定义的．
  重载的print方法可以将各种类型的数据转换成字符串的形式输出．
  重载的write方法只能输出字符／字符数组／字符串等与字符相关的数据．而且如果使用这两种方法输出值为null的字符串对象，那么print方法输出的结果是＂null＂，而write方法则会抛出NullPoiterException异常．
  out.write()是字节输出流的方法
  out.print()是字符输出流的方法
--%>
  <%
    // 不用设置content-type了。因为上面jsp已经给我们设置了
    // page contentType="text/html;charset=UTF-8" language="java"

    System.out.println("hello jsp !");
    String contextPath = request.getContextPath();
    out.print(contextPath);
    out.write(contextPath);

    // 判断是否有cookie
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies != null && cookies.length > 0) {
      for (Cookie cookie : cookies) {
        String name = cookie.getName();
        if ("LastTime".equals(name)) {
          flag = true;
          String value = cookie.getValue();
          System.out.println("解码前：" + value);
          value = URLDecoder.decode(value, "utf-8");
          System.out.println("解码后：" + value);
          response.getWriter().write("<h1>欢迎回来，您上次访问的时间是：" + value + "<h1>");

          Date date = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
          String time = sdf.format(date);
          System.out.println("编码前：" + time);
          time = URLEncoder.encode(time, "utf-8");
          System.out.println("编码后：" + time);
          // 设置存活时间
          cookie.setMaxAge(60 * 60 * 24);
          cookie.setValue(time);
          response.addCookie(cookie);
        }
      }
    }
    if (cookies == null || cookies.length == 0 || flag == false) {
      response.getWriter().write("<h1>您好，欢迎首次访问<h2>");
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
      String time = sdf.format(date);
      System.out.println("编码前：" + time);
      time = URLEncoder.encode(time, "utf-8");
      System.out.println("编码后：" + time);
      Cookie cookie = new Cookie("LastTime", time);
      cookie.setMaxAge(60 * 60 * 24);
      response.addCookie(cookie);
    }
  %>
  <h1>Hi~ jsp！</h1>
  </body>
</html>
