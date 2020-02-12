package ocm.fjx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/myController")
public class MyController {

    @RequestMapping("/test01")
    @ResponseBody
    public String test01(){
        return "hello_my_world";
    }

}
