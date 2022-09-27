package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//디스패쳐 서블릿 동작원리 1
// @RestController
@Controller
public class HelloController {
    //빈 주입
    @Autowired
    HelloService helloService;

    //HelloServlet에 매핑되어있던 요청 매핑해줄 핸들러 작성
    //스프링 MVC가 이 핸들러 쪽으로 요청을 디스패치 해줄, 스프링 애노테이션을 이해하는, 리턴 스트링을 응답으로 만들어줄, 디스패치 서블릿이 필요
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello, " + helloService.getName() + "with DispatcherServlet";
    }

    @GetMapping("/sample")
    public String sample(){
        return "/WEB-INF/sample.jsp";
    }

    
}
