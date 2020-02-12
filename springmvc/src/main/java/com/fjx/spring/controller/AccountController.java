package com.fjx.spring.controller;

import com.fjx.spring.domain.Account;
import com.fjx.spring.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class AccountController {

    @RequestMapping("/saveUser")
    public String saveUser(String username,float money){
        System.out.println(username+"  "+money);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveUser2(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/testDate")
    public String testDate(Date date){
        System.out.println(date);
        return "success";
    }
    @RequestMapping("/find")
    public String find(Model model){
        User user = new User();
        user.setUsername("张三");
        user.setSex("男");
        model.addAttribute("user",user);
        return "success";
    }

}
