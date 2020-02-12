package com.fjx.test;

import com.fjx.ssm02.dao.UserDao;
import com.fjx.ssm02.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Demo {

    @Test
    public void demo1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }

}
