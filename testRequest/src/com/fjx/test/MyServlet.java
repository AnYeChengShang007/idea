package com.fjx.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/servlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String user_agent = request.getHeader("user-agent");
//        System.out.println(user_agent);
//        Enumeration<String> names = request.getHeaderNames();
//        System.out.println(names);
//        while(names.hasMoreElements()){
//            String name = names.nextElement();
//            String value = request.getHeader(name);
//            System.out.println(name+":"+value);
//        }
//        String contextPath = request.getContextPath();
//        System.out.println("contextpath:"+contextPath);
//        StringBuffer url = request.getRequestURL();
//        System.out.println("url:"+url);
//        String uri = request.getRequestURI();
//        System.out.println("uri:"+uri);
//        String referer = request.getHeader("referer");
//        System.out.println(referer);
        /*
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
//            String value = request.getParameter(name);
//            System.out.println(name+":"+value);
//            String[] values = request.getParameterValues(name);
//            for(String value:values){
//                System.out.println(value);
//            }

        }*/
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        Set<String> set = parameterMap.keySet();
//        for(String name:set){
//            String[] values = request.getParameterValues(name);
//            for(String value:values){
//                System.out.println(value);
//            }
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
