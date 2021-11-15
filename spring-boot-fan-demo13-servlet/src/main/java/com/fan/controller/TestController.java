package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/")
    public String tempMethod(){
        System.out.println("123");
        return "list";
    }
}
