package com.fjx.transaction.service;

import com.fjx.transaction.demo.Account;

import java.sql.SQLException;

public interface IUserService {
    public void transfer(String from,String to,float money);

    public Account findByName(String name) throws SQLException;

    public void updateMoney(Account account) throws SQLException;

}
