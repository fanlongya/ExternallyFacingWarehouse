package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyExceptionController {
    @RequestMapping("/exce")
    public String getException()throws Exception{
        throw new Exception("测试异常");
    }
}
