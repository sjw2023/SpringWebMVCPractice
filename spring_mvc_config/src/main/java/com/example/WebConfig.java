package com.example;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.core.Ordered;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.servlet.HandlerAdapter;
// import org.springframework.web.servlet.HandlerMapping;
// import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
// import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
// import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
// import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//Dispatcher 서블릿의 계층 구조를 더이상 사용하지 않을것임.
@ComponentScan //(useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class))
//스프링 웹 엠브잇씨 사요
@EnableWebMvc
//WebMvcConfigurer클래스를 상속 DelegatingWebMvcConfiguration을 더 확장시킬것이다.
public class WebConfig implements WebMvcConfigurer{
    //  뷰리졸버 커스터마이징
    @Override
    public void configureViewResolvers( ViewResolverRegistry registry ){
        registry.jsp("/WEB-INF/", ".jsp");
    }



    // //핸들러 매핑을 빈등록
    // @Bean
    // public HandlerMapping handlerMapping(){
    //     RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
    //     //이렇게 하면 추가적으로 설정해줄수있는부분
    //     //  핸들러를 처리하기 전에 처리해줄 기능을 등록하는 가장 많이 사용하는 셋인터셉터
    //     handlerMapping.setInterceptors();
    //     //  핼들러간에 순서를 정하는 메소드
    //     handlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
    //     return handlerMapping;
    // }
    // @Bean
    // public HandlerAdapter handlerAdapter(){
    //     RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
    //     //  핸들러가 받을 아규먼트를 정의 하는 리졸버
    //     //  handlerAdapter.setArgumentResolvers();
    //     //  핸들러가 받은 값을 @RequestBody를 통해 받는 설정
    //     //  handlerAdapter.setMessageConverters(messageConverters);
    //     return handlerAdapter;
    // }
    // @Bean
    // public ViewResolver viewResolver(){
    //     //  기본 뷰 리졸버 생성
    //     InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    //     //  기본 뷰 리졸버가 기본적으로 생성된다고 하는데 왜 직접빈으로 등록하는가
    //     //  아래처럼 기본설정을 해줄수있다. 
    //     //  모든 뷰파일은 아래 경로에 존재할것이며
    //     viewResolver.setPrefix("/WEB-INF/");
    //     //  모든 뷰파일은 .jsp로 끝날것이다.
    //     viewResolver.setSuffix(".jsp");
    //     return viewResolver;
    // }
}
