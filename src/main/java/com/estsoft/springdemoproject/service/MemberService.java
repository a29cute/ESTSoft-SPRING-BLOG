package com.estsoft.springdemoproject.service;

import com.estsoft.springdemoproject.repository.Member;
import com.estsoft.springdemoproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

//    public MemberService(MemberRepository repository) { // DI
//        this.repository = repository;
//    }

    public List<Member> getAllMembers() {
        return repository.findAll();        // Member 테이블 모든 정보 조회
        // SELECT * FROM member;
    }

    public Member saveMember(Member member) {
        return repository.save(member);
    }

}
