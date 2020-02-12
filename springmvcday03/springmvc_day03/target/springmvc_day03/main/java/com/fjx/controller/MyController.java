package com.fjx.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class MyController {

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/pages/success.jsp");
        return mv;
    }
}
