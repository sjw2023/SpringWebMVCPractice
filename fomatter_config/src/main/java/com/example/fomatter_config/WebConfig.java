/** 포매터를 빈으로 등록하여 더이상 피료없음.
package com.example.fomatter_config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Override
    public void addFormatters( FormatterRegistry registry ){
        registry.addFormatter(new PersonFormatter());
    }
}
**/