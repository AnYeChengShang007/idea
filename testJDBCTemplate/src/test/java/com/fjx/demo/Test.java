package com.fjx.demo;


import com.fjx.template.dao.IAccountDao;
import com.fjx.template.domain.Account;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class Test {

    @Autowired
    private IAccountDao dao;

    @org.junit.Test
    public void testFindAll(){
        List<Account> all = dao.findAll();
        System.out.println(all);
    }
}
