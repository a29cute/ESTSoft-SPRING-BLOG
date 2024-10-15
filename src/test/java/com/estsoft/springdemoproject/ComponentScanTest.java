package com.estsoft.springdemoproject;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 스프링 컨테이너에 등록된 빈 확인해보기 Test Code
 */
public class ComponentScanTest {
    // Test Code
    @Test
    public void test() {
        // 스프링 컨테이너에 등록된 빈 확인을 위한 ApplicationContext 객체 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDemoProjectApplication.class);
        String[] beanNames = context.getBeanDefinitionNames();
        for (String bean : beanNames) {
            System.out.println("#bean name: " + bean);
        }
    }
}
