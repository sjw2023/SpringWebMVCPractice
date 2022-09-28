package com.example.fomatter_config;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    // @GetMapping("/hello")
    // public String hello(){
    //     return "hello";
    // }
    //유알엘 패스를 받는 핸들러로 변경
    // @GetMapping("/hello/{name}")
    // public String hello(@PathVariable String name){
    //     return "hello " + name;
    // }

    //포매터를 사용하기 위한 핸들러로 변경, 문자열을 객체로 받아오기
    // @GetMapping("/hello/{name}")
    // public String hello(@PathVariable("name") Person person){
    //     return "hello " + person.getName();
    // }

    // //리퀘스트 파라미터 사용하도록 수정
    // @GetMapping("/hello")
    // public String hello(@RequestParam("name") Person person){
    //     return "hello " + person.getName();
    // }
      //리퀘스트 파라미터로 ID를 사용하도록 수정
      @GetMapping("/hello")
      public String hello(@RequestParam("id") Person person){
            System.out.println(person.getId());
          return "hello " + person.getName();
      }
}
