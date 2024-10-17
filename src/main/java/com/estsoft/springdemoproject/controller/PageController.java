package com.estsoft.springdemoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
public class PageController {

    @GetMapping("/thymeleaf/example")
    public String show(Model model){

        // Person 객체 생성 및 데이터 설정
        Person person = new Person();
        person.setId(1L);
        person.setName("홍길동"); // name 필드 추가
        person.setAge(20);
        person.setHobbies(Arrays.asList("달리기", "줄넘기", "복싱"));

        // 모델에 데이터 추가
        model.addAttribute("person", person);
        model.addAttribute("today", LocalDateTime.now());

        // examplePage.html 반환
        return "examplePage";
    }
}
