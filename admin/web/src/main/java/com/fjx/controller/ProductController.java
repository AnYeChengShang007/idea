package com.fjx.controller;

import com.fjx.domain.Product;
import com.fjx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> list = service.findAll();
        mv.addObject("productList",list);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Product product){
        String id = UUID.randomUUID().toString().replace("-", "");
        product.setId(id);
        service.save(product);
        return "redirect:findAll";
    }
}
