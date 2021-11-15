package com.fan.filter;


import javax.servlet.*;
import java.io.IOException;
//@Component
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-----customFilter init------");
    }
    private int a=0;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        a++;
        System.out.println("-----customFilter dofilter one------"+a);
        filterChain.doFilter(servletRequest,servletResponse);
        a++;
        System.out.println("-----customFilter dofilter two------"+a);
    }

    @Override
    public void destroy() {
        System.out.println("-------customFilter destroy-------");
    }
}
