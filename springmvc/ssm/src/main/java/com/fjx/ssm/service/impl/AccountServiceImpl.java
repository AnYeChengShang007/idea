package com.fjx.ssm.service.impl;

import com.fjx.ssm.dao.IAccountDao;
import com.fjx.ssm.domain.Account;
import com.fjx.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao dao;

    public List<Account> findAll() {
        System.out.println("service层findAll方法执行");
        return dao.findAll();
    }

    public void save(Account account) {
        System.out.println("service层save方法执行");
        dao.save(account);
    }
}
