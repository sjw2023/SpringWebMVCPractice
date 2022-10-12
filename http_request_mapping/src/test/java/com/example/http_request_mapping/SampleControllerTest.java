package com.example.http_request_mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;;

//Junit 사용시 스프링에서 제공하는 스프링러너를 사용하여 테스트, 좀더 효율적으로 실행이 가능해짐
@RunWith(SpringRunner.class)
//웹 만 테스트 할것이기 때문에 사용
@WebMvcTest
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception{
        //헬로라는 겟 요청을 테스트
        // mockMvc.perform(get("/hello"))
        // .andDo(print())
        // .andExpect(status().isOk())
        // .andExpect(content().string("hello"))
        // ;

        //GET메소드로 핸들러 매핑이후 일부러 틀린 요청을 보냈을때 테스트
        //응답으로 405를 받는지 테스트
        // mockMvc.perform(put("/hello"))
        // .andDo(print())
        // .andExpect(status().isMethodNotAllowed())
        // ;
        //GET메소드로 핸들러 매핑이후 올바른 요청을 보냈을때 테스트
        //응답으로 200을 받는지 테스트
        // mockMvc.perform(get("/hello"))
        // .andDo(print())
        // .andExpect(status().isOk())
        // ;
        // //GET, put메소드로 핸들러 매핑이후 올바른 요청을 보냈을때 테스트
        // //응답으로 200을 받는지 테스트
        // mockMvc.perform(put("/hello"))
        // .andDo(print())
        // .andExpect(status().isOk())
        // ;

        // //요청 식별자 테스트 코드
        // mockMvc.perform(put("/hello5"))
        // .andDo(print())
        // .andExpect(status().isOk())
        // ;
        //요청 식별자 테스트 코드
        // mockMvc.perform(put("/hello/ㅁㄴㅇㄹ~~~/multi"))
        // .andDo(print())
        // .andExpect(status().isOk())
        // ;
        //정규식 테스트 코드
        // mockMvc.perform(put("/hello/joowon"))
        // .andDo(print())
        // .andExpect(status().isOk())
        // ;

        //추가적인 유용한 테스트 코드
          //정규식 테스트 코드
          mockMvc.perform(put("/hello/joowon"))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(handler().handlerType(SampleController.class)) //올바른 컨트롤러가 핸들링 하는지
          .andExpect(handler().methodName("hello")) //핸들러 이름 체크
          ;
    }
}
