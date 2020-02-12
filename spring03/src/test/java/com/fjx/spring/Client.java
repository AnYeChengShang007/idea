package com.fjx.spring;

import com.fjx.spring.domain.User;
import com.fjx.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = applicationContext.getBean("UserService",UserService.class);
        try {
            List<User> all = userService.findAll();
            for(User user:all){
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
