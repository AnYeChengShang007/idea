package com.fjx.controller;

import com.fjx.domain.Role;
import com.fjx.domain.UserInfo;
import com.fjx.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> all = service.findAll();
        mv.addObject("userList",all);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        String id = UUID.randomUUID().toString().replace("-", "");
        userInfo.setId(id);
        service.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = service.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = service.findById(id);
        List<Role> roleList = service.findAllRoleByUerId(id);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam("userId") String userId, @RequestParam("ids") String[] ids){
        service.addRoleToUser(userId,ids);
        return "redirect:findById?id="+userId;
    }
}
