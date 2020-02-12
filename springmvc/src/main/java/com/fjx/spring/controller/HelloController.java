package com.fjx.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class HelloController {
    @RequestMapping(path="/hello",params="username")
    public String sayHello(){
        System.out.println("hello");
        return "success";
    }

    @RequestMapping("testOrigin")
    public void test(HttpServletRequest request,HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
        HttpSession session = request.getSession();
        System.out.println(session);
    }

    @RequestMapping("testPathVariable/{int}")
    public String pathv(@PathVariable("int") Integer id){
        System.out.println(id);
        return "success";
    }
}
