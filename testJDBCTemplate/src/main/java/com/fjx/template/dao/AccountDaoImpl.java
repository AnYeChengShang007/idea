package com.fjx.template.dao;

import com.fjx.template.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate runner;

    public List<Account> findAll() {
        List<Account> accounts = runner.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        return accounts;
    }

    public void add(Account account) {
        runner.update("insert into account (name,money) values (?,?)",account.getName(),account.getMoney());
    }

    public void delete(int id) {
        runner.update("delte from account where id=?",id);
    }

    public Account findOne(int id) {
        List<Account> accounts = runner.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
        Account account;
        if(accounts==null){
            throw new RuntimeException("结果集空");
        }
        account = accounts.size()==1?accounts.get(0):null;
        return account;
    }

    public Account findByName(String name) {
        List<Account> accounts = runner.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts==null){
            throw new RuntimeException("没有此人");
        }
        Account account = accounts.size()==1?accounts.get(0):null;
        return account;
    }

    public void update(Account account) {
        runner.update("update account set user name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
