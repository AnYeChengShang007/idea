package com.fjx.transaction.dao;

import com.fjx.transaction.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository("dao")
public class AccountDao implements IAccountDao {

    @Autowired
    private JdbcTemplate runner;

    public Account findByName(String name) throws SQLException {
        List<Account> accounts = runner.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if(accounts==null){
            throw new RuntimeException("没有");
        }else if(accounts.size()>1){
            throw new RuntimeException("多于一个");
        }
        return accounts.get(0);
    }

    public void updateMoney(Account account) throws SQLException {
        runner.update("update account set money=? where id=?",account.getMoney(),account.getId());
    }
}
