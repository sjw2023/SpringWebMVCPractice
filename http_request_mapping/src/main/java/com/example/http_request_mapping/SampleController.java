package com.example.http_request_mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    //GET, POST, PUT, PATCH, DELETE 등의 http 메소드가 지정되지 않으면 모든 메소드를 허용.
    //핸들러를 hello라는 요청에 매핑 하고 싶을때
    // @RequestMapping("/hello")
    //GET Http Method만 허용 하고 싶으면
    // @RequestMapping(value="/hello", method = RequestMethod.GET)
    //GET과 PUT모두 허용 하고싶을때 배열을 사용
    @RequestMapping(value="/hello", method = {RequestMethod.GET, RequestMethod.PUT})
    //리턴 문자열을 응담으로 보내고 싶을때 붙이는 어노테이션
    @ResponseBody
    public String hello(){
        //리턴에 해당하는 뷰를 찾아가는 핸들러
         return "hello";
    }
    
}
