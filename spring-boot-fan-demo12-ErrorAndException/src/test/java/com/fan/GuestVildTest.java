package com.fan;

import com.fan.bean.Guest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class GuestVildTest {
    public static void main(String[] args) {
        Validator validator= Validation.buildDefaultValidatorFactory().getValidator();
        Validator validator1=Validation.byDefaultProvider().configure().addProperty("hibernate.validator.fail_fast","true").buildValidatorFactory().getValidator();
        Guest guest=new Guest(null,null);
        Set<ConstraintViolation<Guest>> validateSet=validator.validate(guest);
        for(ConstraintViolation violation:validateSet){
            System.out.println(violation.getPropertyPath()+":"+violation.getMessage());
        }
        Set<ConstraintViolation<Guest>> validateSet1=validator1.validate(guest);
        for(ConstraintViolation violation:validateSet1){
            System.out.println(violation.getPropertyPath()+":"+violation.getMessage());
        }
    }
}
