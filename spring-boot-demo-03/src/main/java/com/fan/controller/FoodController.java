package com.fan.controller;

import com.fan.bean.FoodRice;
import com.fan.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
    @Autowired
    private FoodRice foodRice;

    @RequestMapping("/friedRice")
    public Food friedRice() {
        Food food = new Food();
        food.setMeat(foodRice.getMeat());
        food.setRice(foodRice.getRice());
        return food;
    }
}
