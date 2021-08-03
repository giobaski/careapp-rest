package com.example.KnCare.service;

import com.example.KnCare.dto.MemberDto;
import com.example.KnCare.mapper.MapperInterface;
import com.example.KnCare.model.Member;
import com.example.KnCare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MemberService extends ServiceBase<Member, MemberDto>{

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository, MapperInterface<Member, MemberDto> mapper) {
        super(mapper);
        this.memberRepository = memberRepository;
    }

    public List<MemberDto> getAll() { return toDtoList(memberRepository.findAll()); }

    public Optional<MemberDto> getbyId(long id) {
        return toDtoOptional(memberRepository.findById(id));
    }

    public MemberDto Add(MemberDto memberDto) {
        Member member = toModel(memberDto);
        return toDto(memberRepository.save(member));
    }

    public void delete(Long id){
        memberRepository.deleteById(id);
    }
    public void deleteAll(){
        memberRepository.deleteAll();
    }

    public Page<MemberDto> searchMember(MemberDto memberDto) {
        Member member = toModel(memberDto);
        return toDtoPage(memberRepository.findAll(member.getSpecification(), member.getPageable()));
    }
}
