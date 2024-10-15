package com.estsoft.springdemoproject.interf;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
@Service
public class InterImplA implements Inter {
    @Override
    public void method() {
        System.out.print("hi A");
    }
}
