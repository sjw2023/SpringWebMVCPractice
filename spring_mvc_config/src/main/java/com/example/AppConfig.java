package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;


@Configuration
//컨트롤러는 빈으로 등록하지 않겠다는 옵션.
@ComponentScan( excludeFilters = @ComponentScan.Filter(Controller.class))
public class AppConfig {
    
}
