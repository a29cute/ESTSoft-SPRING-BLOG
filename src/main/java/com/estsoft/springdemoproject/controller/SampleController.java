package com.estsoft.springdemoproject.controller;

import com.estsoft.example.HiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HiService 빈이 컴포넌트 스캔의 대상 아니라면 DI 불가
 */
@Controller
public class SampleController {
//    private HiService hiService;
//
//    public SampleController(HiService hiService) {
//        this.hiService = hiService;
//    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hi";        // -> "hi.html"
    }
}
