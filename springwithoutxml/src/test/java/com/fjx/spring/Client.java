package com.fjx.spring;

import com.fjx.spring.config.JdbcConfig;
import com.fjx.spring.config.SpringConfig;
import com.fjx.spring.domain.User;
import com.fjx.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfig.class)
public class Client {
    @Resource(name="UserService")
    private UserService userService = null;

    @Test
    public void test01(){
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
