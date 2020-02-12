package com.fjx.ssm02.controller;

import com.fjx.ssm02.pojo.User;
import com.fjx.ssm02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> all = userService.findAll();
        model.addAttribute("userList",all);
        return "userList";
    }
}
