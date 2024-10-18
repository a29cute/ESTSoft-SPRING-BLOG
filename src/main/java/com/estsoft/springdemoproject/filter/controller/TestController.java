package com.estsoft.springdemoproject.filter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> test(@RequestParam String query) {

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("query", query);

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}