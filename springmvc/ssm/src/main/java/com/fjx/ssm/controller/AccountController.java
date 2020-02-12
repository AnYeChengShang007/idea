package com.fjx.ssm.controller;


import com.fjx.ssm.domain.Account;
import com.fjx.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("controller的findAll方法执行了");
        List<Account> all = service.findAll();
        System.out.println(all);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",all);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/insert")
    public String insert(Account account){
        System.out.println("controller的insert方法执行了");
        service.save(account);
        return "success";
    }
}
