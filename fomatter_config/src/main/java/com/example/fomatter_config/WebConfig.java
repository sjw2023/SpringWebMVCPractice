/** 포매터를 빈으로 등록하여 더이상 피료없음. 인터셉터 등록을 위해 다시 사용**/
package com.example.fomatter_config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
        registry.addInterceptor(new GreetingIntercaptor()).order(1);
        registry.addInterceptor(new AnotherInterceptor())
        //  패스 패턴
        .addPathPatterns("/hi")
        //  우선순위
        .order(-1);
    }

    //리소스 핸들러 등록
    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ){
        registry.addResourceHandler("/mobile/**") //    /mobile/로 들어오는 모든 요청에 적용
        .addResourceLocations("classpath:/mobile/") //  클래스패스 루트 아래 있는 모바일
        .setCacheControl(CacheControl.maxAge(10,TimeUnit.MINUTES)); // 응답에 캐싱 전략을 사용, 10분동안 유지
    }

        //마셜러 객체를 빈으로 등록, 마셜링에 사용하기 위해
        
        @Bean
        public Jaxb2Marshaller jaxb2Marshaller(){
            Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
            //  패키지스캔을 통해 마셜러에게 패키지 위치를 알려줘야함
            jaxb2Marshaller.setPackagesToScan(Person.class.getPackageName());
            return jaxb2Marshaller;
        }

}
