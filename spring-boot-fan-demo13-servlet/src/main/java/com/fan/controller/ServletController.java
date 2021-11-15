package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
public class ServletController {
    @RequestMapping("/servlet")
    public String testServlet(){
        System.out.println("456");
        return "insert";
    }
}
