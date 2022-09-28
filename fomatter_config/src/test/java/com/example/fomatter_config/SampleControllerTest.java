package com.example.fomatter_config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
}
