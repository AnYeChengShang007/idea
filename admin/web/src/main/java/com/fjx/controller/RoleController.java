package com.fjx.controller;

import com.fjx.domain.Role;
import com.fjx.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private IRoleService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> list = service.findAll();
        mv.addObject("roleList",list);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role){
        role.setId(UUID.randomUUID().toString().replace("-",""));
        service.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        Role role = service.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(String id){
        ModelAndView mv = new ModelAndView();
        Role role = service.findRoleByIdAndAllPermission(id);
        mv.addObject("role",role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    public String addPermissionsToRole(String roleId, @RequestParam("ids") String[] permissionIds){
        service.addPermissionsToRole(roleId,permissionIds);
        return "redirect:findById?id="+roleId;
    }

}
