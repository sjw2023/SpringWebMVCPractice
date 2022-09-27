package com.example.fomatter_config;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
//포매터 빈으로 등록, 웹설정파일 사용안하도록 만듬.
@Component
public class PersonFormatter implements Formatter<Person>{
    @Override
    public Person parse(String text, Locale locale) throws ParseException{
        Person person = new Person();
        person.setName(text);
        return person;
    }
    @Override
    public String print(Person object, Locale locale){
        return object.toString();
    }
    
}
