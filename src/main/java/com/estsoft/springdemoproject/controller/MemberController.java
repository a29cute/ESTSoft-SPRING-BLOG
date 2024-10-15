package com.estsoft.springdemoproject.controller;

import com.estsoft.springdemoproject.repository.Member;
import com.estsoft.springdemoproject.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public List<Member> getAllMember() {
        return memberService.getAllMembers();
    }

    // HTTP Post Method 요청(/members) 받는 메소드
    @PostMapping("/members")
    public Member saveMember(@RequestBody Member member) {
        // member 정보 저장하는 service 코드 호출
        return memberService.saveMember(member);
    }
}
