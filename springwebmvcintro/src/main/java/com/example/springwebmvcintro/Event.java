package com.example.springwebmvcintro;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//모델 객체 (이벤트) Pojo
//  이름
//  언제 하는지
//  몇명이나 참가할수있는지
//  등의 정보를 담을것임

//  롬복 애노테이션을 사용하면 컴파일 시점에 자동으로 
//  애노테이션으로 추가한 메소드들이 클래스에 같이 생성된다
//  타겟 디렉토리에서 빌드후에 확인 가능.
//  롬복으로 게터 세터 추가
@Getter @Setter
//  롬복 빌더 생성, 노 아규먼트, 올 아규먼트 두개
@Builder @NoArgsConstructor @AllArgsConstructor
public class Event {
    private String name;
    private int limitOfEnrollmentl;
    private LocalDateTime startDateTime;
    private LocalDateTime  endDateTime;
}
