package com.fan.config;

import com.fan.filter.CustomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {
    @Bean
    public Filter testFilter(){
        return new CustomFilter();
    }
    @Bean
    public FilterRegistrationBean<CustomFilter> addFilter(){
        FilterRegistrationBean<CustomFilter> filterFilterRegistrationBean=new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter( (CustomFilter) testFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
//        filterFilterRegistrationBean.setOrder(0);
        return filterFilterRegistrationBean;
    }
}
