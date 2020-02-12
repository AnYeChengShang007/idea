package com.fjx.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/demo3")
public class Demo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath(filename);
        InputStream in = new BufferedInputStream(
                new FileInputStream(realPath)
        );
        response.setContentType(servletContext.getMimeType(filename));
        filename = DownLoadUtils.getFileName(request.getHeader("user-agent"),filename);
        response.setHeader("content-disposition","attachment;filename="+filename);
        ServletOutputStream out = response.getOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while(-1!=(len=in.read(buff))){
            out.write(buff,0,len);
        }
        out.close();
        in.close();
    }
}
