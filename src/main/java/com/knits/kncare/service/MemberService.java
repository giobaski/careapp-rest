package com.knits.kncare.service;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.mapper.MemberMapper;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

//    public List<Member> getAll() { return memberRepository.findAll(); }
    public List<MemberDto> getAll() {
        return memberRepository.findAll()
                .stream()
                .map(member -> memberMapper.toDto(member))
                .collect(Collectors.toList());
    }

    public Optional<Member> getbyId(long id) {
        return memberRepository.findById(id);
    }

//    public Member Add(Member member) { return memberRepository.save(member);}

    public MemberDto create (MemberDto memberDto){
        //TODO: Check before saving whether member with same employee_id exists or not
        Member createdMember = memberRepository.save(memberMapper.toModel(memberDto));
        return memberMapper.toDto(createdMember);
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
