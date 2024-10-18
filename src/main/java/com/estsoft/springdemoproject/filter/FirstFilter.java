package com.estsoft.springdemoproject.filter;

import jakarta.servlet.FilterConfig;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("FirstFilter doFilter() request");

        // client가 요청한 URL을 로깅
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();
        System.out.println(requestURI + " on FirstFilter");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("FirstFilter doFilter() response");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroy()");
    }
}