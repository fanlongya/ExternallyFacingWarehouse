package com.fan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "customFilter2",urlPatterns = "/*")
public class CustomFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-----customFilter2 init------");
    }
    private int a=0;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        a++;
        System.out.println("-----customFilter2 dofilter one------"+a);
        filterChain.doFilter(servletRequest,servletResponse);
        a++;
        System.out.println("-----customFilter2 dofilter two------"+a);
    }

    @Override
    public void destroy() {
        System.out.println("-------customFilter2 destroy-------");
    }
}
