package com.fjx.transaction.service;

import com.fjx.transaction.dao.IAccountDao;
import com.fjx.transaction.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("accountService")
public class AccountSerice implements IUserService{

    @Autowired
    private IAccountDao dao;


    public void transfer(String from, String to, float money) {
        try {
            Account f = dao.findByName(from);
            Account t = dao.findByName(to);
            f.setMoney(f.getMoney()-money);
            t.setMoney(t.getMoney()+money);
            dao.updateMoney(f);
            int i=1/0;
            dao.updateMoney(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    public void updateMoney(Account account) throws SQLException {
        dao.updateMoney(account);
    }
}
