package com.fan.controller;

import com.fan.model.Guest;
import com.fan.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService service;

    @GetMapping
    @Transactional
    public String selectList(Model model) {
        List<Guest> guestlist = service.selectList();
        model.addAttribute("guests", guestlist);
        return "list";
    }
}
