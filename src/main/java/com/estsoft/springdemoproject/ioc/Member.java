package com.estsoft.springdemoproject.ioc;

/**
 * 스프링 빈으로 등록되지 않은 Member 클래스(POJO) 예시
 */
public class Member {
    private int id;
    private String name;
    private String address;

    public Member(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
