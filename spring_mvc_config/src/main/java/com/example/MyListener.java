package com.example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    //컨텍스트 실행시
    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("Context Initialized");
        //컨텐스트에 애트리뷰트 추가
        sce.getServletContext().setAttribute("name", "joowon");
    }
    //컨텍스트 종료시
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("Context Destroyed");
    }

}
