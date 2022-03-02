package com.springdatajpa.repository;

import com.springdatajpa.domain.Member;

import java.util.List;

public interface MemberRepositoryCustom {


    List<Member> findMemberCustom();
}
