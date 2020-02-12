package com.fjx.controller;


import com.fjx.domain.Item;
import com.fjx.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemService service;

    @RequestMapping("/findById")
    public String findById(Model model, Integer id){
        Item item = service.findById(id);
        System.out.println(item);
        model.addAttribute("item",item);
        return "item";
    }

}
