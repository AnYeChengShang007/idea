package com.fjx.ssm02.service;

import com.fjx.ssm02.dao.UserDao;
import com.fjx.ssm02.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }
}
