package com.fan.handler;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceprionHandler(Exception e){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/error/exception");
        modelAndView.addObject("message",e.getMessage());
        return modelAndView;
    }
}
