package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController {
    @RequestMapping("/error404")
    public String myErrorHtml(){
        return "/error/error404";
    }
}
