package com.example.http_request_mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//스프링이 어플리케이션 구동중에 핸들러로 사용해야 하므로
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET, value = "hello")
public @interface GetHelloMapping {
    
}
