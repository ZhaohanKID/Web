package org.it.web.download;

import org.it.web.utils.DownloadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/7 10:46
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求参数，文件名称
        String filename = request.getParameter("filename");
        // 2 使用字节输入流加载文件进内存
        // 2-1 找到文件的服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        // 2-2 使用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        // 3 设置response的响应头
        // 3-1 响应头类型：content-type
        String mimeType = context.getMimeType(filename);
        response.setHeader("content-type", mimeType);
        // 3-2 设置响应头打开方式 attachment 以附件形式打开

        // 解决中文文件名问题
        /*String agent = response.getHeader("user-agent");
        filename = DownloadUtils.getFileName(agent, filename);*/

        response.setHeader("content-disposition", "attachment;filename=" + filename);

        // 4 将输入流的数据写入到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int length = 0;
        while ((length = fis.read(bytes)) != -1) {
            sos.write(bytes, 0, length);
        }

        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
