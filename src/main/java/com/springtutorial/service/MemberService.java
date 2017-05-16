package com.springtutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springtutorial.domain.Member;
import com.springtutorial.repository.MemberRepository;

import java.util.List;

@Service("MemberService")
//@Transactional
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAllOrderByName();
    }
    
    public Member findOne(Integer id) {
    	return memberRepository.findOne(id);
    }
    
    public Member create(Member member) {
        return memberRepository.save(member);
    }
    
    public Member update(Member member) {
    	return memberRepository.save(member);
    }
    
    public void delete(Integer id) {
    	memberRepository.delete(id);
    }
}