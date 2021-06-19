package com.fan.controller;


import com.fan.domain.Guest;
import com.fan.service.GuestServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestServise guestServise;

    @RequestMapping("/hello")
    public String test() {
        return "Hello Word!";
    }

    @RequestMapping("/list")
    public String guestList(Model model) {
        model.addAttribute("guests", guestServise.selectAllGuest());
        return "list";
    }

    @RequestMapping("/toAdd")
    public String guestToAdd() {
        return "insert";
    }

    @RequestMapping("/add")
    public String guestAdd(Guest guest) {
        guestServise.add(guest);
        return "redirect:/guest/list";
    }

    @RequestMapping("/toUpdate")
    public String guestToUpdate(Model model, Long id) {
        model.addAttribute("guest", guestServise.getGuest(id));
        return "update";
    }

    @RequestMapping("/update")
    public String guestUpdate(Guest guest) {
        guestServise.update(guest);
        return "redirect:/guest/list";
    }

    @RequestMapping("/delete")
    public String guestDelete(Long id) {
        guestServise.delete(id);
        return "redirect:/guest/list";
    }

}
