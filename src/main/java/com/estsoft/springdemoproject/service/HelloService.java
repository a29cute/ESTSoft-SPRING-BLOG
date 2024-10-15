package com.estsoft.springdemoproject.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String printHello(String param) {
        return "Hello " + param;
    }
}
