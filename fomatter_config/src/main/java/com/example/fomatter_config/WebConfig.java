/** 포매터를 빈으로 등록하여 더이상 피료없음. 인터셉터 등록을 위해 다시 사용**/
package com.example.fomatter_config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    //포매터는 사용 안함    
    // @Override
    // public void addFormatters( FormatterRegistry registry ){
    //     registry.addFormatter(new PersonFormatter());
    // }

    //  인터셉터 등록
    @Override
    public void addInterceptors( InterceptorRegistry registry ){
        registry.addInterceptor(new GreetingIntercaptor());
        registry.addInterceptor(new AnotherInterceptor());
    }
}
