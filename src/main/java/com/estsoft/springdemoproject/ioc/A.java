package com.estsoft.springdemoproject.ioc;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * DI + IoC + Interface 다형성
 * -> 개념 참고
 * <p>
 * A 클래스에서
 * 일반 클래스에 의존 VS interface에 의존
 * 각 경우에 변경사항 생겼을 경우, 인터페이스가 변경에 더 유리
 * -> 만약 A클래스에서 Inter라는 인터페이스를 생성자 주입(DI)해 준다면, method2()처럼 사용 가능
 */
public class A {
    Inter inter;
    public A(Inter inter) {     // Dependency Injection & IoC(inter 객체의 제어권은 Spring에게 있음)
        this.inter = inter;
    }

    /**
     * 사용자가 직접 객체를 제어(생성)
     * : B->C 변경사항 생겼을 떄 코드 변경 범위 생각해보기
     */
    public void method() {
//        B objectB = new B();
//        objectB.methodB();

// 만약 B->C 클래스 메소드 기능으로 바꿔야한다면? 코드 변경 범위 커짐
        C objectC = new C();
        objectC.method();
    }

    /**
     * 인터페이스로 객체 선언 : 변경에 유리
     */
    public void method2() {
        inter.method();
    }
}
