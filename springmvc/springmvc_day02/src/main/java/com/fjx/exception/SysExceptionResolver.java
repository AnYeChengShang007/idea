package com.fjx.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        System.out.println("ssss");
        e.printStackTrace();
        SysException ex = null;
        if(e instanceof SysException){
            ex = (SysException)e;
        }else{
            e = new SysException("请联系管理员");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
