package com.example.http_request_mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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
        mockMvc.perform(get("/hello"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("hello"))
        ;
    }
}
