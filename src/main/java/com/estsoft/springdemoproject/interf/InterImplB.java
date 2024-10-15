package com.estsoft.springdemoproject.interf;

import org.springframework.stereotype.Service;

@Service
public class InterImplB implements Inter {
    @Override
    public void method() {
        System.out.print("hi B");
    }
}
