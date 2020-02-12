package com.fjx.demo;


import com.fjx.transaction.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class TestTransfer {

    @Resource(name="accountService")
    private IUserService service;

    @Test
    public void transfer(){
        service.transfer("jack","lucy",100);
    }

}
