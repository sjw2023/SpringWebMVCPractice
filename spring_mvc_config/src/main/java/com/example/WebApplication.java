package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplication implements WebApplicationInitializer{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException{
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //  @SpringWebMvc사용을 위한 서블릿 컨텍스트 설정
        context.setServletContext(servletContext);
        //설정 파일 설정
        context.register( WebConfig.class );
        context.refresh();

        //디스패쳐 서블릿 생성
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        //디스패쳐 서블릿 등록
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
        //매핑
        app.addMapping("/app/*");
    }
}
