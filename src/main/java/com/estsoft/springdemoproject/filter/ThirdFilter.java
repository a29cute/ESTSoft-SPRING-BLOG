package com.estsoft.springdemoproject.filter;

import jakarta.servlet.FilterConfig;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;


public class ThirdFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ThirdFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("ThirdFilter doFilter() reqeust");

        // 클라이언트가 요청으로 넘긴 파라미터 수정
        filterChain.doFilter(new RequestWrapper((HttpServletRequest) servletRequest), servletResponse);

        System.out.println("ThirdFilter doFilter() response");
    }

    @Override
    public void destroy() {
        System.out.println("ThirdFilter destroy()");
    }

    private static class RequestWrapper extends HttpServletRequestWrapper {

        public RequestWrapper(HttpServletRequest request) {
            super(request);
        }

        /**
         * 클라이언트가 파라미터로 전달한 값에 "123" 문자열을 concat 하기위한 메소드
         */
        @Override
        public String[] getParameterValues(String parameter) {
            String[] values = super.getParameterValues(parameter); // 전달받은 parameter 가져오기

            if (values == null) {
                return null;
            }

            for (int i = 0; i < values.length; i++) {
                if (values[i] != null) {
                    // parameter 끝에 "123" 문자열 추가
                    values[i] = values[i] + "123";
                }
            }
            return values;
        }
    }
}