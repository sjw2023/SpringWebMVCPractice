package com.example.fomatter_config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
@RunWith(SpringRunner.class)
// @WebMvcTest
//포매터를 빈으로 등록하기위해
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    // @Test
    // public void hello() throws Exception {
    //     this.mockMvc.perform(get("/hello"))//요청
    //     .andDo(print())//결과 출력
    //     .andExpect(content().string("hello"));//결과 비교
    // }
    //유알엘 패스 버라이어블 테스트
    // @Test
    // public void hello() throws Exception {
    //     this.mockMvc.perform(get("/hello/joowon"))//요청
    //     .andDo(print())//결과 출력
    //     .andExpect(content().string("hello joowon"));//결과 비교
    // }

    //리퀘스트 파라미터 포매터 테스트
    // @Test
    // public void hello() throws Exception {
    //     this.mockMvc.perform(get("/hello")
    //     .param("name", "joowon"))//파라미터 가지고 요청
    //     .andDo(print())//결과 출력
    //     .andExpect(content().string("hello joowon"));//결과 비교
    // }

    //ID를 사용하여 테스트하도록 수정
    //생성한 리파지토리 주입
    @Autowired
    PersonRepository personRepository;

    @Test
    public void hello() throws Exception {
        //퍼슨 객체에 정보 저장
        Person person = new Person();
        person.setName("joowon");
        Person savedPerson = personRepository.save(person);

        this.mockMvc.perform(get("/hello")
        .param("id", savedPerson.getId().toString()))//파라미터 가지고 요청
        .andDo(print())//결과 출력
        .andExpect(content().string("hello joowon"));//결과 비교
    }
    //인덱스 테스트 코드
    @Test
    public void helloStatic() throws Exception{
        this.mockMvc.perform(get("/index.html"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(Matchers.containsString("hello index")));
    }

    //헬로 모바일 테스트 코드
    @Test
    public void helloMobile() throws Exception{
        this.mockMvc.perform(get("/mobile/index.html"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(Matchers.containsString("hello mobile")))
        .andExpect(header().exists(HttpHeaders.CACHE_CONTROL)); //캐싱 전략을 사용하는지 체크
    }
    //스트링 컨버터 테스트 코드
    @Test
    public void stringMessage() throws Exception{
        this.mockMvc.perform(get("/message").content("hello"))// 바디에 hello담아 요청을 보냄
        .andDo(print())// 결과 출력
        .andExpect(status().isOk())//200 인지 확인
        .andExpect(content().string(Matchers.containsString("hello")))//응답에 그대로 hello 있는지 확인
        ;
    }
    //제이슨 컨버터 테스트 코드

    //잭슨이 제공하는 오브젝트 매퍼를 사용하여 제이슨 문자열을 만들기 위해 사용
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void jsonMessage() throws Exception{
        //제이슨 문자열로 만들어줄 퍼슨 객체
        Person person = new Person();
        person.setId(2019);
        person.setName("joowon");
        //제이슨 문자열로 변경
        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonMessage")
                                .contentType(MediaType.APPLICATION_JSON) // 요청에 컨텐츠 타입을 입력해 컨버터를 사용하도록 하기 위해.
                                .accept(MediaType.APPLICATION_JSON) //  응답으로 어떤 컨텐츠 타입을 허욜할 것인지 명시.
                                .content(jsonString))// 바디에 제이슨 문자열 담아 요청
        .andDo(print())// 결과 출력
        .andExpect(status().isOk())//200 인지 확인 
        .andExpect(jsonPath("$.id").value(2019)) // 제이슨 출력결과 비교
        .andExpect(jsonPath("$.name").value("joowon"))
        ;
    }
}
