package com.springdatajpa.controller;

import com.springdatajpa.domain.Member;
import com.springdatajpa.dto.MemberDto;
import com.springdatajpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    @GetMapping("/members2/{id}")
    public String findMember2(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    @GetMapping("/members")
    public Page<MemberDto> list(@PageableDefault(size = 10) Pageable pageable) {
        return memberRepository.findAll(pageable).map(MemberDto::new);
    }


    @PostMapping
    public void init() {
        for(int i = 0; i < 100; i++) {
            memberRepository.save(new Member("user" + i, i));
        }

    }
}
