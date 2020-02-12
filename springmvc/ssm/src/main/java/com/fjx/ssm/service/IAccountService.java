package com.fjx.ssm.service;

import com.fjx.ssm.domain.Account;

import java.util.List;

public interface IAccountService {

    public List<Account> findAll();

    public void save(Account account);
}
