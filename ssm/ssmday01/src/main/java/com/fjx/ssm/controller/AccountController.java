package com.fjx.ssm.controller;


import com.fjx.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService service;

    @RequestMapping("/test")
    public String test(){
        service.add();
        return "success";
    }
}
