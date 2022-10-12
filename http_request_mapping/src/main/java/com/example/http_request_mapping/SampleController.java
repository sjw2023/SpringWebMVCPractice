package com.example.http_request_mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//클래스레벨 어노테이션과 조합하여 사용
//@RequestMapping("/hello")
public class SampleController {

    //GET, POST, PUT, PATCH, DELETE 등의 http 메소드가 지정되지 않으면 모든 메소드를 허용.
    //핸들러를 hello라는 요청에 매핑 하고 싶을때
    // @RequestMapping("/hello")
    //GET Http Method만 허용 하고 싶으면
    // @RequestMapping(value="/hello", method = RequestMethod.GET)
    //GET과 PUT모두 허용 하고싶을때 배열을 사용
    // @RequestMapping(value="/hello", method = {RequestMethod.GET, RequestMethod.PUT})
    // //리턴 문자열을 응담으로 보내고 싶을때 붙이는 어노테이션
    // @ResponseBody
    // public String hello(){
    //     //리턴에 해당하는 뷰를 찾아가는 핸들러
    //      return "hello";
    // }
    

    // @RequestMapping( {"/hello", "/hi"}) // URI 매핑 하는 부분, 한번에 다수의 매핑도 가능
    // //리턴 문자열을 응담으로 보내고 싶을때 붙이는 어노테이션
    // @ResponseBody
    // public String hello(){
    //     //리턴에 해당하는 뷰를 찾아가는 핸들러
    //      return "hello";
    // }

    //요청 식별자 사용 코드

    // @RequestMapping( "/hello?") // URI 매핑 하는 부분, ?는 아무 한글자에 매핑
    // //즉 요청은 hello + 아무런한글자로 들어와야함

    // //리턴 문자열을 응담으로 보내고 싶을때 붙이는 어노테이션
    // @ResponseBody
    // public String hello(){
    //     //리턴에 해당하는 뷰를 찾아가는 핸들러
    //      return "hello";
    // }

    // @RequestMapping( "/hello*") // URI 매핑 하는 부분, ?는 아무 여러글자에 매핑
    // //즉 요청은 hello + 여러글자로 들어와야함
    // //리턴 문자열을 응담으로 보내고 싶을때 붙이는 어노테이션
    // @ResponseBody
    // public String hello(){
    //     //리턴에 해당하는 뷰를 찾아가는 핸들러
    //      return "hello";
    // }
    
    // @RequestMapping( "/hello/**") // URI 매핑 하는 부분, **는 아무 여러 패스에 매핑
    // //즉 요청은 hello + 추가 패스 로 들어와야함
    // //리턴 문자열을 응담으로 보내고 싶을때 붙이는 어노테이션
    // @ResponseBody
    // public String hello(){
    //     //리턴에 해당하는 뷰를 찾아가는 핸들러
    //      return "hello";
    // }

    // @RequestMapping( "/**") // URI 매핑 하는 부분, **는 아무 여러 패스에 매핑
    // //즉 요청은 hello + 추가 패스 로 들어와야함
    // //리턴 문자열을 응담으로 보내고 싶을때 붙이는 어노테이션
    // @ResponseBody
    // public String hello(){
    //     //리턴에 해당하는 뷰를 찾아가는 핸들러
    //      return "hello";
    // }

    //정규식 사용하기
    @RequestMapping( "/hello/{name:[a-z]+}") // URI 매핑 하는 부분, name이라는 변수로 받아와서
    //리턴 문자열을 응담으로 보내고 싶을때 붙이는 어노테이션
    @ResponseBody
    //pathvariable 로 name을 넘기는 모습
    public String hello(@PathVariable String name){
        //리턴에 해당하는 뷰를 찾아가는 핸들러
         return "hello";
    }

}
