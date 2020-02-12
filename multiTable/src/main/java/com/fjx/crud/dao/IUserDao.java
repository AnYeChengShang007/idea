package com.fjx.crud.dao;

import com.fjx.crud.domain.User;

import java.util.List;

public interface IUserDao {
    public List<User> findAll();
    public User findOne(Integer id);
    public List<User> findAll2();
}
