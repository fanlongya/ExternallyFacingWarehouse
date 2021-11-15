package com.fan.resolver;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Component
public class MyErrorResolver implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        if(status.equals(HttpStatus.NOT_FOUND)){
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("/error/resolver404");
            return modelAndView;
        }
        return null;
    }
}
