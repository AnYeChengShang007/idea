package com.fjx.ssm02.dao;

import com.fjx.ssm02.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
}
