package com.fjx.transaction.dao;

import com.fjx.transaction.demo.Account;

import java.sql.SQLException;

public interface IAccountDao {

    public Account findByName(String name) throws SQLException;

    public void updateMoney(Account account) throws SQLException;
}
