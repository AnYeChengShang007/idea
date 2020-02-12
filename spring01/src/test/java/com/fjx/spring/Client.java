package com.fjx.spring;

import com.fjx.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("bean.xml");
        UserService service = application.getBean("UserService", UserService.class);
        service.save();
    }
}
