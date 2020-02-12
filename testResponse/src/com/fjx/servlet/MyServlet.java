package com.fjx.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo1")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到此");
        response.sendRedirect("/testResponse/demo2.jsp");
        ServletContext servletContext = this.getServletContext();
        String mimeType = servletContext.getMimeType("a.js");
        System.out.println(mimeType);
        String realPath = servletContext.getRealPath("考试复习.docx");
        System.out.println(realPath);
    }
}
