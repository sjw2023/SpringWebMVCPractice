package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//Dispatcher 서블릿의 계층 구조를 더이상 사용하지 않을것임.
@ComponentScan //(useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class))
public class WebConfig {
    @Bean
    public ViewResolver viewResolver(){
        //  기본 뷰 리졸버 생성
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //  기본 뷰 리졸버가 기본적으로 생성된다고 하는데 왜 직접빈으로 등록하는가
        //  아래처럼 기본설정을 해줄수있다. 
        //  모든 뷰파일은 아래 경로에 존재할것이며
        viewResolver.setPrefix("/WEB-INF/");
        //  모든 뷰파일은 .jsp로 끝날것이다.
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
