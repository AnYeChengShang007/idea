package com.fjx.crud.dao;

import com.fjx.crud.domain.Account;
import com.fjx.crud.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    public List<Account> findAll();
    public List<AccountUser> findAll2();
}
