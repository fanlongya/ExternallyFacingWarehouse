package com.fan.controller;

import com.fan.bean.Food;
import com.fan.domain.EmpConfig;
import com.fan.domain.FoodConfig;
import com.fan.domain.User;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class FoodController {
    //    @Value("${food.meat}")
//    private String meat;
//    @Value("${food.rice}")
//    private String rice;
//    @Value("${seasoning}")
//    private String[] seasoning;
    @Value("${boo}")
    private boolean boo;
    //    @Value("${num}")
//    private int[] nums;
//    @Value("${str}")
//    private String[] strs;
    @Autowired
    private EmpConfig empConfig;
    @Autowired
    private FoodConfig foodConfig;

    @RequestMapping("/food")
    public Food meatRice() {
        Food food = new Food();
        food.setMeat(foodConfig.getMeat());
        food.setRice(foodConfig.getRice());
        food.setSeasoning(foodConfig.getSeasoning());
        System.out.println(boo + " : " + Arrays.toString(empConfig.getNum()) + " : " + Arrays.toString(empConfig.getStr()));
        return food;
    }

    @Autowired
    private User user;

    @RequestMapping("/nameAndPassword")
    public String nameAndPassword() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("147258369");
        String $name = textEncryptor.encrypt("hehe");
        String $password = textEncryptor.encrypt("hehe123456");
        System.out.println($name + "   " + $password);
//        StringBuffer stringBuffer=new StringBuffer();String name,String password$name+":"+$password
//        stringBuffer.append(user.getName()[0]);
//        stringBuffer.append("    ");
//        stringBuffer.append(user.getName()[1]);
//        stringBuffer.append("    ");
//        stringBuffer.append(user.getPassword()[0]);
//        stringBuffer.append("    ");Arrays.toString(Arrays.toString(
//        stringBuffer.append(user.getPassword()[1]);
        System.out.println(user.getNames());
//        System.out.println(textEncryptor.decrypt(user.getNames()));
//        System.out.println(textEncryptor.decrypt(user.getPassword()));
        System.out.println(user.getPassword());
        return "";
    }
}
