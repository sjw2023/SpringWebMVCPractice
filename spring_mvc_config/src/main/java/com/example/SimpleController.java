package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//컨트롤러 애노테이션을 사용해 빈 등록을 할때 이름을 지정해줌 빈 이름"/simple"
@org.springframework.stereotype.Controller("/simple")
public class SimpleController implements Controller{

    //뷰 정보로 simple.jsp의 위치, 모델은 뷰가 사용할 데이터로 2번째 파라미터로 넘기지만 이번엔 사용안함.
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
        
        //  뷰 리졸버를 설정파일에 설정후 이렇게 변경가능
        return new ModelAndView( "simple");//"/WEB-INF/simple.jsp");
    }
    
}
