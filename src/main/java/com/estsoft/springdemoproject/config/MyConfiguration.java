package com.estsoft.springdemoproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * com.estsoft.example 패키지 하위에 있는 빈 선언들도 Scan해서 빈 등록
 */
@Configuration
@ComponentScan(basePackages = "com.estsoft.example")
public class MyConfiguration {
}
