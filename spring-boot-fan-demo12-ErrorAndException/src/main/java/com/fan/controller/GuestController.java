package com.fan.controller;

import com.fan.bean.Guest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GuestController {
    @PostMapping("/addGuest")
    public String addGuest(@Valid Guest guest, BindingResult result){
        System.out.println(guest.getName()+":"+guest.getPassword());
        if(result.getErrorCount()>0) {
            List<FieldError> list = result.getFieldErrors();
            StringBuilder builder=new StringBuilder();
            for(FieldError fieldError:list){
                builder.append(fieldError.getField());
                builder.append("\t");
                builder.append(fieldError.getDefaultMessage());
                builder.append("\n");
            }
            System.out.println(builder.toString());
            return builder.toString();
        }
        return "success";
    }
}
