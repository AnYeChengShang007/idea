package com.fjx.controller;

import com.fjx.domain.Orders;
import com.fjx.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    IOrderService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam Integer pageNum,@RequestParam Integer size){

        List<Orders> all = service.findAll(pageNum,size);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam("id") String id){
        ModelAndView mv = new ModelAndView();
        Orders order = service.findById(id);
        mv.setViewName("orders-show");
        mv.addObject("orders",order);
        return mv;
    }
}
