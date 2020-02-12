package com.fjx.demo;

import com.fjx.service.IService;
import com.fjx.service.ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IService service = applicationContext.getBean("serviceImpl", IService.class);
        service.add();
//        service.delete(1);
//        service.update();
    }
}
