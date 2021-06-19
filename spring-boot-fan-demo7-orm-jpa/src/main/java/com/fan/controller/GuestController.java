package com.fan.controller;


import com.fan.domain.Guest;
import com.fan.service.GuestServiseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestServiseImpl guestServise;

    @GetMapping
    public String guestList(Model model) {
        model.addAttribute("guests", guestServise.selectAllGuest());
        return "list";
    }
//    @RequestMapping("/toAdd")
//    public String guestToAdd(){
//        return "insert";
//    }
//    @PostMapping
//    public String guestAdd(Guest guest){
//        guestServise.add(guest);
//        return "redirect:/guest";
//    }
//    @RequestMapping("/toUpdate/{id}")
//    public String guestToUpdate(Model model,@PathVariable("id") Long id){
//        model.addAttribute("guest",guestServise.getGuest(id));
//        return "update";
//    }
//    @PutMapping
//    public String guestUpdate(Guest guest){
//        guestServise.update(guest);
//        return "redirect:/guest";
//    }
//    @DeleteMapping("/{id}")
//    public String guestDelete(@PathVariable("id") Long id){
//        System.out.println(id+"----");
//        guestServise.delete(id);
//        return "redirect:/guest";
//    }

}
