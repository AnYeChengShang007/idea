package com.fjx.testSpringMVC.conteoller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjx.testSpringMVC.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo01")
public class Demo01 {
    @RequestMapping("/test01")
    public ModelAndView test01(String name){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",name);
        System.out.println(name);
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("/test02")
    public ModelAndView test02(){
        ModelAndView mv = new ModelAndView();
        User user = new User("张三","男");
        ObjectMapper mapper = new ObjectMapper();
        String msg = null;
        try {
            msg = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        mv.addObject("msg",msg);
        mv.setViewName("main");
        return mv;
    }
}
