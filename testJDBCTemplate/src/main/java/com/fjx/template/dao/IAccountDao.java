package com.fjx.template.dao;

import com.fjx.template.domain.Account;

import java.util.List;

public interface IAccountDao {

    public List<Account> findAll();

    public void add(Account account);

    public void delete(int id);

    public Account findOne(int id);

    public Account findByName(String name);

    public void update(Account account);
}
