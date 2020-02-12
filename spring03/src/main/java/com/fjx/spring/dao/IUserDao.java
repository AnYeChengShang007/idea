package com.fjx.spring.dao;

import com.fjx.spring.domain.Account;
import com.fjx.spring.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public void save(User user) throws SQLException;

    public List<User> findAll() throws SQLException;

    public User findOne(int id) throws SQLException;

    public void update(User user) throws SQLException;

    public void delete(int id) throws SQLException;
}
