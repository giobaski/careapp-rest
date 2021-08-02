package com.example.KnCare.service;

import com.example.KnCare.model.Member;
import com.example.KnCare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAll() { return memberRepository.findAll(); }

    public Optional<Member> getbyId(long id) {
        return memberRepository.findById(id);
    }

    public Member Add(Member member) {
        return memberRepository.save(member);
    }

    public void delete(Long id){
        memberRepository.deleteById(id);
    }
    public void deleteAll(){
        memberRepository.deleteAll();
    }

    public Page<Member> searchMember(Member member) {
        return memberRepository.findAll(member.getSpecification(), member.getPageable());
    }
}
