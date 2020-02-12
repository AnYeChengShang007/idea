package com.fjx.ssm.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {



    public void add() {
        System.out.println("AccountService.add()!!!");
    }
}
