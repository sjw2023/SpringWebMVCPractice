package com.example;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig ) throws ServletException{
        System.out.println("Filter Init");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws UnsupportedOperationException, IOException, ServletException{
        System.out.println("Filter");//그냥 이것만 두면 출력안됨 FilterChain 파라미터를 이용해 다음 필터로 넘겨줘야함
        chain.doFilter(request, response);// 다음 필터로 연결해주는 부분, 맨 마지막 필터는 알아서 서블릿으로 연결해줌
    }
    @Override
    public void destroy(){
        System.out.println("Filter Destroy");

    }
    
}
