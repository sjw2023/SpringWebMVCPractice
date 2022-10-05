package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    
    //핸들러로 매핑
    // @RequestMapping
    //특정 URL을 핸들러로 매핑하고 싶을때 (hello라는 요청이 오면 아래 한들러가 처리 하도록 하겠다는 의미.)
    @RequestMapping("/hello")
    //리턴하는 문자열을 응답으로 보내고 싶을때 붙이는 어노테이션
    @ResponseBody
    public String hello(){
        //리턴 벨류 값의 이름에 해당하는 뷰를 찾아 가도록하는 핸들러
        return "hello";
    }
}
