package com.knits.kncare.service;

import com.knits.kncare.model.Member;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Member> searchMember(Member member) {
        return memberRepository.findAll();
    }
}
