package com.knits.kncare.service;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.dto.pages.JsonPageImpl;
import com.knits.kncare.dto.search.MemberSearchDto;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService extends ServiceBase<Member, MemberDto>{

    private final MemberRepository memberRepository;

    public MemberService(MapperInterface<Member, MemberDto> mapper, MemberRepository memberRepository) {
        super(mapper);
        this.memberRepository = memberRepository;
    }


    public MemberDto create (MemberDto memberDto) {
        //TODO: Check before saving whether member with same employee_id exists or not
        Member createdMember = memberRepository.save(toModel(memberDto));
        return toDto(createdMember);
    }

    //    public List<Member> getAll() { return memberRepository.findAll(); }
    public List<MemberDto> getAll() {  //delete this after implementing search
        return memberRepository.findAll()
                .stream()
                .map(member -> toDto(member))
                .collect(Collectors.toList());
    }

    public Optional<Member> getbyId(long id) {
        return memberRepository.findById(id);
    }
    public Member Add(Member member) { return memberRepository.save(member); }

    public void delete(Long id){
        memberRepository.deleteById(id);
    }
    public void deleteAll(){
        memberRepository.deleteAll();
    }

    public Page<MemberDto> search(MemberSearchDto memberSearchDto) {
        Page<Member> memberPage = repository.findAll(memberSearchDto.getSpecification(), memberSearchDto.getPageable());
        return new JsonPageImpl<>(toDtoList(memberPage.getContent()), memberSearchDto.getPageable(), memberSearchDto.getPageable().getPageSize());
    }
}
